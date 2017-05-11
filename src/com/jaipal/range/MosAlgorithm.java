package com.jaipal.range;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MosAlgorithm {

    static int add(int[] a, int[] cnt, int i) {
        return ++cnt[a[i]] == 1 ? 1 : 0;
    }

    static int remove(int[] a, int[] cnt, int i) {
        return --cnt[a[i]] == 0 ? -1 : 0;
    }

    public static int[] processQueries(int[] a, Query[] queries) {
        for (int i = 0; i < queries.length; i++) queries[i].index = i;
        int sqrtn = (int) Math.sqrt(a.length);
        Arrays.sort(queries, (q1, q2) -> {
            int cmp = Integer.compare(q1.a / sqrtn, q2.a / sqrtn);
            return cmp != 0 ? cmp : Integer.compare(q1.b, q2.b);
        });
        int[] cnt = new int[1000_000002];
        int[] res = new int[queries.length];
        int L = 1;
        int R = 0;
        int cur = 0;
        for (Query query : queries) {
            while (L < query.a) cur += remove(a, cnt, L++);
            while (L > query.a) cur += add(a, cnt, --L);
            while (R < query.b) cur += add(a, cnt, ++R);
            while (R > query.b) cur += remove(a, cnt, R--);
            res[query.index] = cur;
        }
        return res;
    }

    static void compress(int[] a) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++)
            hm.put(a[i], 1);
        int p = 0;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            e.setValue(p);
            p++;
        }
        for (int i = 0; i < a.length; i++)
            a[i] = hm.get(a[i]);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 4};
        Query[] queries = {new Query(0, 3), new Query(1, 3), new Query(2, 3), new Query(3, 3)};
        int[] res = processQueries(a, queries);
        System.out.println(Arrays.toString(res));
    }

    public static class Query {
        int index;
        int a;
        int b;

        public Query(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
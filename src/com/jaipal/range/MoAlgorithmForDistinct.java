package com.jaipal.range;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by dreddy on 4/27/2017.
 */
public class MoAlgorithmForDistinct {
    private static int BLOCK;
    private static int[] cnt = new int[1000001];
    private static int res = 0;
    private static int[] ans;

    public MoAlgorithmForDistinct(int[] a, int n, QueryMO[] q, int m) {
        MOAlgo(a, n, q, m);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.readInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = in.readInt();
        int m = in.readInt();
        QueryMO[] q = new QueryMO[m];
        for (int i = 0; i < m; i++) {
            q[i] = new QueryMO(in.readInt(), in.readInt(), i);
        }
        ans = new int[m];
        MoAlgorithmForDistinct moq = new MoAlgorithmForDistinct(a, n, q, m);
        for (int i = 0; i < m; i++)
            out.println(ans[i]);
        out.flush();

    }

    static void update(int i) {
        cnt[i]++;
        if (cnt[i] == 1)
            res++;
    }

    static void remove(int i) {
        cnt[i]--;
        if (cnt[i] == 0)
            res--;
    }

    private void MOAlgo(int[] a, int n, QueryMO[] q, int m) {

        BLOCK = (int) Math.sqrt(n);
        Arrays.sort(q);
        int currL = 1, currR = 0;

        for (int i = 0; i < m; i++) {
            // L and R values of current range
            int L = q[i].L;
            int R = q[i].R;
            // Remove extra elements of previous range. For
            // example if previous range is [0, 3] and current
            // range is [2, 5], then a[0] and a[1] are subtracted
            while (currL < L) {
                remove(a[currL]);
                currL++;
            }

            // Add Elements of current Range
            while (currL > L) {
                currL--;
                update(a[currL]);

            }
            while (currR < R) {
                currR++;
                update(a[currR]);

            }

            // Remove elements of previous range.  For example
            // when previous range is [0, 10] and current range
            // is [3, 8], then a[9] and a[10] are subtracted
            while (currR > R) {
                remove(a[currR]);
                currR--;
            }
            ans[q[i].id] = res;
            //System.out.println("Range : L ==> " + L + " R ==> " + R + " Size : " + set.size());
        }


    }

    static class QueryMO implements Comparable<QueryMO> {
        public int L;
        public int R;
        public int id;
        public int ans;

        public QueryMO(int L, int M, int id) {
            this.L = L;
            this.R = M;
            this.id = id;
        }

        @Override
        public int compareTo(QueryMO x) {
            if (x.L / BLOCK != this.L / BLOCK) {
                // different blocks, so sort by block.
                return x.L / BLOCK < this.L / BLOCK ? -1 : 1;
            }
            // same block, so sort by R value
            return x.R < this.R ? -1 : 1;
        }
    }

    static class InputReader {
        private BufferedReader input;
        private StringTokenizer line = new StringTokenizer("");

        public InputReader(InputStream in) {
            input = new BufferedReader(new InputStreamReader(in));
        }

        public void fill() {
            try {
                if (!line.hasMoreTokens()) {
                    line = new StringTokenizer(input.readLine());
                }
            } catch (IOException io) {
                io.printStackTrace();
                System.exit(0);
            }
        }

        public String next() {
            fill();
            return line.nextToken();
        }

        public int readInt() {
            fill();
            return Integer.parseInt(line.nextToken());
        }

        public void readIntArray(int[] a, int n) {
            for (int i = 0; i < n; i++)
                a[i] = readInt();
        }

    }
}

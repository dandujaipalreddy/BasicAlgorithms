package com.jaipal.range;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MOAlgorithmFrequency {
    private static int BLOCK;
    private static int[] cnt;
    private static int res = 0;
    private static int[] ans;
    private static int[] above;

    public MOAlgorithmFrequency(int[] a, int n, QueryMO[] q, int m) {
        MOAlgo(a, n, q, m);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.readInt();
        while (t > 0) {
            int n = in.readInt();
            int m = in.readInt();
            int[] a = new int[n + 1];
            cnt = new int[1000001];
            above = new int[1000001];
            res = 0;
            for (int i = 1; i <= n; i++)
                a[i] = in.readInt();

            QueryMO[] q = new QueryMO[m];
            for (int i = 0; i < m; i++) {
                q[i] = new QueryMO(in.readInt(), in.readInt(), i, in.readInt());
            }
            ans = new int[m];
            MOAlgorithmFrequency moq = new MOAlgorithmFrequency(a, n, q, m);
            for (int i = 0; i < m; i++)
                out.println(ans[i]);
            t--;
        }
        out.flush();

    }

    static void update(int i) {
        above[cnt[i]]++;
        cnt[i]++;

    }

    static void remove(int i) {
        cnt[i]--;
        above[cnt[i]]--;
    }

    private void MOAlgo(int[] a, int n, QueryMO[] q, int m) {

        BLOCK = (int) Math.sqrt(n);
        Arrays.sort(q);
        int currL = 1, currR = 0;

        for (int i = 0; i < m; i++) {
            // L and R values of current range
            int L = q[i].L;
            int R = q[i].R;
            int freq = q[i].x;
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
            ans[q[i].id] = above[0]-above[freq];
            //System.out.println("Range : L ==> " + L + " R ==> " + R + " Size : " + set.size());
        }


    }

    static class QueryMO implements Comparable<QueryMO> {
        public int L;
        public int R;
        public int id;
        public int ans;
        public int x;

        public QueryMO(int L, int M, int id, int x) {
            this.L = L;
            this.R = M;
            this.id = id;
            this.x = x;
        }

        @Override
        public int compareTo(QueryMO x) {
            if (x.L / BLOCK != this.L / BLOCK) {
                // different blocks, so sort by block.
                return x.L / BLOCK < this.L / BLOCK ? 1 : -1;
            }
            // same block, so sort by R value
            return x.R < this.R ? 1 : -1;
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

package com.jaipal.range;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dreddy on 4/27/2017.
 */
public class MOAlgorithmForSum {
    private static int BLOCK;

    public MOAlgorithmForSum(int[] a, int n, QueryMO[] q, int m) {
        MOAlgo(a, n, q, m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int m = in.nextInt();
        QueryMO[] q = new QueryMO[m];
        for (int i = 0; i < m; i++) {
            q[i] = new QueryMO(in.nextInt(), in.nextInt());
        }
        MOAlgorithmForSum moq = new MOAlgorithmForSum(a, n, q, m);

    }

    private void MOAlgo(int[] a, int n, QueryMO[] q, int m) {

        BLOCK = (int) Math.sqrt(n);
        Arrays.sort(q);
        int currL = 0, currR = 0;
        int currSum = 0;
        for (int i = 0; i < m; i++) {
            // L and R values of current range
            int L = q[i].L;
            int R = q[i].R;
            // Remove extra elements of previous range. For
            // example if previous range is [0, 3] and current
            // range is [2, 5], then a[0] and a[1] are subtracted
            while (currL < L) {
                currSum -= a[currL];
                currL++;
            }

            // Add Elements of current Range
            while (currL > L) {
                currSum += a[currL - 1];
                currL--;
            }
            while (currR <= R) {
                currSum += a[currR];
                currR++;
            }

            // Remove elements of previous range.  For example
            // when previous range is [0, 10] and current range
            // is [3, 8], then a[9] and a[10] are subtracted
            while (currR > R + 1) {
                currSum -= a[currR - 1];
                currR--;
            }
            System.out.println("Range : L ==> " + L + " R ==> " + R + " SUM : " + currSum);
        }


    }

    static class QueryMO implements Comparable<QueryMO> {
        public int L;
        public int R;

        public QueryMO(int L, int M) {
            this.L = L;
            this.R = M;
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
}

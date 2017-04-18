package com.jaipal.dp;

/**
 * Created by dreddy on 4/5/2017.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public static int LCS(int m, int n, String X, String Y) {

        int[][] LCS = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            LCS[i][0] = 0;
        for (int i = 0; i <= n; i++)
            LCS[0][i] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; i++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        return LCS[m][n];

    }

    public static int LCSRecursive(int m, int n, String X, String Y) {
        if (m == 0 || n == 0) return 0;
        if (X.charAt(m) == X.charAt(n)) return 1 + LCSRecursive(m - 1, n - 1, X, Y);
        return Math.max(LCSRecursive(m, n - 1, X, Y), LCSRecursive(m - 1, n, X, Y));
    }
}


package com.jaipal.dp;

import java.util.Scanner;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert,Remove,Replace
 */
public class EditDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        System.out.println(countDP(s1, s2, s1.length(), s2.length()));
    }

    public static long countRecursive(String s1, String s2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return countRecursive(s1, s2, m - 1, n - 1);
        long insert = countRecursive(s1, s2, m, n - 1);
        long replace = countRecursive(s1, s2, m - 1, n - 1);
        long remove = countRecursive(s1, s2, m - 1, n);
        return 1 + Math.min(insert, Math.min(remove, replace));
    }

    public static long countDP(String s1, String s2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++) {
                if (j == 0)
                    dp[i][j] = i;
                else if (i == 0)
                    dp[i][j] = j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
            }

        return dp[m][n];
    }
}

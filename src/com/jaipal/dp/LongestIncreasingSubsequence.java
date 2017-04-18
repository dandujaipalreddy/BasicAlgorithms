package com.jaipal.dp;

/**
 * Created by dreddy on 4/4/2017.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(longestIncreasingSubsequence(arr, arr.length));

    }

    public static int longestIncreasingSubsequence(int[] a, int n) {

        int[] lis = new int[n];
        for (int i = 0; i < n; i++)
            lis[i] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i] && lis[j] + 1 > lis[i])
                    lis[i] = lis[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];
        return max;
    }
}

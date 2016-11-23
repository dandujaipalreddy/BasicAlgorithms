package com.jaipal.sort;

/**
 * Created by Jai on 11/15/2016.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 8, 1, 3, 7, 9, 2};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

    }

    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
        for (int i = left; i < right; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int partition(int[] a, int left, int right) {

        int i = left, j = right;
        int tmp;
        int pivot = a[(left + right) / 2];
        while (i <= j) {
            while (a[i] < pivot)
                i++;
            while (a[j] > pivot)
                j--;
            if (i <= j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static int partition(int[] a, int p) {

        int pivot = a[p];
        int i = a.length;
        for (int j = a.length - 1; j >= 0; j--) {
            if (a[j] > pivot) {
                i--;
                if (i != j) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        int temp = a[i - 1];
        a[i - 1] = a[0];
        a[0] = temp;
        return i - 1;
    }

}


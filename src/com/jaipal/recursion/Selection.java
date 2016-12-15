package com.jaipal.recursion;

public class Selection {


    public static void selectionWithDuplicates(int[] arr, int start, int end, int[] data, int index, int r) {
        if (index == r) {
            for (int i = 0; i < r; i++)
                System.out.print(data[i] + " ");

            System.out.println();
            return;
        }

        for (int i = start; i <= end; i++) {
            data[index] = arr[i];
            selectionWithDuplicates(arr, i, end, data, index + 1, r);
        }
    }

    public static void selectionWithOutDuplicates(int[] arr, int start, int end, int[] data, int index, int r) {
        if (index == r) {
            for (int i = 0; i < r; i++)
                System.out.print(data[i] + " ");

            System.out.println();
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            selectionWithOutDuplicates(arr, i + 1, end, data, index + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[2];
        selectionWithDuplicates(new int[]{1, 2, 3, 4}, 0, 3, data, 0, 2);
        selectionWithOutDuplicates(new int[]{1, 2, 3, 4}, 0, 3, data, 0, 2);

    }
}

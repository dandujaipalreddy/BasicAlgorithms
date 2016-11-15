package com.jaipal.sort;

import java.util.PriorityQueue;

/**
 * Created by Jai on 11/15/2016.
 */
public class BasicSorts {
    public static void main(String[] args) {

        int[] a = {2, 3, 1, 5, 4, 10, 9, 8, 0, 13};
        a = insertionSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    /* idea:selects the minimum element and advance
    * Time Complexity:O(n*n)
    * DS Used: array
    * Space Complexity : O(1)
    * No of swaps/data moves : n-1
    * We are using array to store the elements and retrieve the minimum.
    * .so what if we improve the data structure to retrieve the minimum(Ex:PriorityQueue) It beomes HaepSort
    * */
    public static int[] selectionSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (a[min] > a[j]) min = j;
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }

        return a;
    }

    /*
    * insertion in to priorityQueue=O(logN)
    * deletion from PQ=O(logN)
    * getting min from PQ=O(1)
    * Time Complexity of heapSort: O(logN+N*logN)=O(NlogN)
    * space Complexity : O(logN)
    *
    * */
    public static int[] heapSort(int[] a) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++)
            PQ.add(a[i]);
        int i = 0;
        while (!PQ.isEmpty())
            a[i++] = PQ.poll();
        return a;
    }

    /*
        insert the element in the proper position
        Time Complexity=O(n*n)
        Space Complexity = O(n)
        No of swaps=No of inversions
        An inversion is a pair of elements which are out of order i.e. i<j  then a[i]>a[j]
     */
    public static int[] insertionSort(int[] a) {

        int length = a.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
        return a;
    }


}

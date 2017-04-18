package com.jaipal.recursion;

/**
 * Created by dreddy on 12/15/2016.
 */
public class Permutation {

    public static void Permutate(int[] a, int start, int end) {

        if (start > end) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + " ");
            System.out.println();
            return;
        }

        for(int i=start;i<=end;i++){
            int temp=a[i];
            a[i]=a[start];
            a[start]=temp;
            Permutate(a.clone(),start+1,end);
            a[start]=a[i];
            a[i]=temp;
        }

    }

    public static void main(String[] args) {

        int[] a={1,2,3,4,5};
        Permutate(a,0,4);
    }
}

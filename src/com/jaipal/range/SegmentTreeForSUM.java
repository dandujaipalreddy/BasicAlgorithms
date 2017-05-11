package com.jaipal.range;

import java.util.Arrays;

/**
 * Created by dreddy on 4/27/2017.
 */
public class SegmentTreeForSUM {


    public int[] segementTree;

    public SegmentTreeForSUM(int[] a, int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        segementTree = new int[max_size];
        constructSegementTree(a, 0, n - 1, 0);
    }

    public int getMid(int a, int b) {
        return a + (b - a) / 2;
    }


    // A recursive function that constructs Segment Tree for array[ss..se].
    // current is index of current node in segment tree st
    public int constructSegementTree(int[] arr, int ss, int se, int current) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            segementTree[current] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        segementTree[current] = constructSegementTree(arr, ss, mid, current * 2 + 1)
                + constructSegementTree(arr, mid + 1, se, current * 2 + 2);

        return segementTree[current];
    }

    public int getSum(int n, int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    /*  A recursive function to get the sum of values in given range
            of the array.  The following are parameters for this function.

          st    --> Pointer to segment tree
          si    --> Index of current node in the segment tree. Initially
                    0 is passed as root is always at index 0
          ss & se  --> Starting and ending indexes of the segment represented
                        by current node, i.e., st[si]
          qs & qe  --> Starting and ending indexes of query range */
    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return segementTree[si];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    /* A recursive function to update the nodes which have the given
       index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    void updateValueUtil(int ss, int se, int i, int diff, int si)
    {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        segementTree[si] = segementTree[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    void updateValue(int arr[], int n, int i, int new_val)
    {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SegmentTree{");
        sb.append("segementTree=").append(Arrays.toString(segementTree));
        sb.append('}');
        return sb.toString();
    }
}

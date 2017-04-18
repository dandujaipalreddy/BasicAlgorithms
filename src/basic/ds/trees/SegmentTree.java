package basic.ds.trees;

import java.util.Arrays;

/**
 * Created by dreddy on 4/12/2017.
 */
public class SegmentTree {

    public int[] segementTree;

    public SegmentTree(int[] a, int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        segementTree = new int[max_size];
        constructSegementTree(a, 0, n - 1, 0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree s = new SegmentTree(arr, arr.length);
        System.out.println(Arrays.toString(s.segementTree));
    }

    public int getMid(int a, int b) {
        return a + (b - a) / 2;
    }

    public int constructSegementTree(int[] arr, int ss, int se, int current) {
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


    public void updateValueUtil(int ss, int se, int i, int diff, int si)
    {

        if (i < ss || i > se)
            return;
        segementTree[si] = segementTree[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    public void updateValue(int arr[], int n, int i, int new_val)
    {
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        int diff = new_val - arr[i];
        arr[i] = new_val;
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    public int getSumUtil(int ss, int se, int qs, int qe, int si) {

        if (qs <= ss && qe >= se)
            return segementTree[si];
        if (se < qs || ss > qe)
            return 0;
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }



}

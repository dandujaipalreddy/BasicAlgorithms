package eocp.arrays;

/**
 * Write a function that takes an array A and an index i into A, and
 * rearranges the elements such that all elements less than A[i] appear first, followed
 * by elements equal to A[i], followed by elements greater than A[i]. Your algorithm
 * should have 0(1) space complexity and OOAI)time complexity
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] a = rearrange(new int[]{3, 8, 9, 6, 6, 10, 1, 2, 6}, 3);
        for (int i : a)
            System.out.print(i + " ");
    }

    public static int[] rearrange(int[] A, int index) {

        int ele = A[index];
        int smallest = 0, largest = A.length - 1, equal = 0;
        while (equal <= largest) {
            if (A[equal] < ele) {
                int temp = A[equal];
                A[equal] = A[smallest];
                A[smallest] = temp;
                smallest++;
                equal++;
            } else if (A[equal] == ele) equal++;
            else {
                int temp = A[equal];
                A[equal] = A[largest];
                A[largest] = temp;
                largest--;
            }
        }
        return A;
    }


}


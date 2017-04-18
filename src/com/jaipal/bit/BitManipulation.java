package com.jaipal.bit;

/**
 *
 */
public class BitManipulation {

    /*  The parity of a sequence of bits is 1 if the number of Is in the sequence is odd;
        otherwise, it is O. Parity checks are used to detect single bit errors in data storage and
        communication.
    */
    public static short calculateParity(long x) {
        short result = 0;
        while (x != 0) {
            //x&1 => 0 if x is even and 1 if x is odd
            result ^= (x & 1);
            x >>= 1;
        }
        return result;
    }

    public static long swapBits(long x, int i, int j) {

        if (((x >> i) & 1) != ((x >> j) & 1)) {
            long u = (1L << i | 1L << j);
            x ^= u;
        }
        return x;
    }

    public static long complemetBits(int x){
        int num=0;
        int i=0;
        while(x!=0){
            int l= (x>>0) & 1;
            if(l==0)
                num+=(1<<i);
            x>>=1;
            i++;
        }
        return num;
    }




    public static void main(String args[]) {
        // System.out.println(calculateParity(13));
        System.out.println(complemetBits(1));
    }
}

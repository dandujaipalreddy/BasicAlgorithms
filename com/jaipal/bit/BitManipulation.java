package com.jaipal.bit;

/**
 * Created by dreddy on 11/1/2016.
 */
public class BitManipulation {

    /*  The parity of a sequence of bits is 1 if the number of Is in the sequence is odd;
        otherwise, it is O. Parity checks are used to detect single bit errors in data storage and
        communication.
    */
    public static short calculateParity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>= 1;
        }
        return result;
    }


    public static void main(String args[]) {
        System.out.println(calculateParity(13));
    }
}

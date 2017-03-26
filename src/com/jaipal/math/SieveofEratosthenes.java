package com.jaipal.math;


import java.util.ArrayList;
import java.util.List;

public class SieveofEratosthenes {

    public static void main(String[] args) {
        segmentedSieve(100);

    }

    public static void simpleSieve(int n, List<Integer> primesArray) {

        boolean[] primes = new boolean[n + 1];
        primes[2] = false;
        int LIMIT = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i <= LIMIT; i++) {
            if (!primes[i]) {
                for (int j = 2 * i; j <= n; j += i)
                    primes[j] = true;
            }
        }
        for (int i = 2; i <= n; i++)
            if (!primes[i]) {
                primesArray.add(i);
            }
    }

    public static void segmentedSieve(int n) {

        int LIMIT = (int) Math.ceil(Math.sqrt(n));
        List<Integer> primes = new ArrayList<>();
        simpleSieve(LIMIT, primes);
        int low = LIMIT;
        int high = 2 * LIMIT;
        while (low < n) {
            boolean[] prime=new boolean[LIMIT+1];
            for (Integer p : primes) {
                int loLimit= (low/p)*p;
                if(loLimit<low)
                    loLimit+=p;

                for(int i=loLimit;i<high;i+=p)
                    prime[i-low]=true;
            }
            for(int i=low;i<high;i++){
                if(!prime[i-low])
                    System.out.print(i+" ");
            }
            System.out.println();
            low  = low + LIMIT;
            high = high + LIMIT;
            if (high >= n) high = n;
        }

    }
}

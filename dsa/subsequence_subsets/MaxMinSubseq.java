package dsa.subsequence_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxMinSubseq {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 5, 7, 9, 12 }))));
    }

    static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        int mod = 1000000007;
        long max = 0, min = 0;
        for (int i = 0; i < n; i++) {
            max = (max + A.get(i) * pow(2, i, mod)) % mod;
            min = (min + A.get(i) * pow(2, n - i - 1, mod)) % mod;
        }

        return (int) (max - min + mod) % mod;

    }

    static long pow(int n, int p, int mod) {

        if (p == 0)
            return 1;
        if (p == 1)
            return n;
        long pow = 1;

        pow = (pow % mod * pow(n, p / 2, mod)) % mod;
        pow = (pow % mod * pow % mod) % mod;
        if (p % 2 == 1) {
            pow = (n % mod * pow % mod) % mod;
        }
        return pow;

    }

}

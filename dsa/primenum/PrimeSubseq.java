package dsa.primenum;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSubseq {

    public static void main(String[] args) {
        System.out
                .println(solve(new ArrayList<Integer>(
                        Arrays.asList(new Integer[] {}))));

        // System.out.println(isPrime(16));
    }

    static int solve(ArrayList<Integer> A) {
        int mod = 1000000007;
        int count = 0;
        for (Integer i : A) {
            if (isPrime(i)) {
                count++;
            }
        }
        int ans = pow(2, count, mod) - 1;
        return ans;
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int pow(int a, int b, int m) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        long p = (long) pow(a, b / 2, m);
        if ((b & 1) == 1) {
            // odd
            return (int) (p % m * p % m * a % m) % m;

        } else {
            // even
            return (int) (p % m * p % m) % m;
        }

    }

}

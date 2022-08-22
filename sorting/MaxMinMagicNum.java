package sorting;

import java.util.Arrays;

public class MaxMinMagicNum {

    public static void main(String[] args) {
        MaxMinMagicNum magic = new MaxMinMagicNum();
        magic.solve(new int[] { 5, 4, 9, 12, 6, 3 });
    }

    public int[] solve(int[] A) {
        int n = A.length;
        int mod = 1000000007;
        Arrays.sort(A);
        long max = 0;
        long min = 0;

        int j = n / 2;
        for (int i = 0; i < n / 2; i++, j++) {
            long diff = A[i] - A[j];
            max = (max + (long) (Math.abs(diff) % mod)) % mod;
        }

        for (int i = 0; i < n - 1; i += 2) {
            long diff = A[i] - A[i + 1];
            min += (long) (Math.abs(diff) % mod);
        }

        return new int[] { (int) max % mod, (int) min % mod };

    }
}
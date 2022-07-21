package modulo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PairSumDivisibleByM {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 5, 17, 100, 11 })), 28));
    }

    // E 395875462 A 1395875469
    static int solve(ArrayList<Integer> A, int B) {
        long mod = 1000000007;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < B; i++) {
            hm.put(i, 0);
        }

        for (Integer i : A) {
            int remainder = i % B;
            hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);

        }
        // long pairCount = (long) ((hm.get(0) % mod * (((hm.get(0) % mod - 1 % mod) +
        // mod) % mod) % mod) % mod) / 2;
        long pairCount = (hm.get(0) * (hm.get(0) - 1)) / 2;
        pairCount %= mod;
        int i = 1, j = B - 1;
        while (i < j) {
            // pairCount = (pairCount % mod + ((hm.get(i) % mod * hm.get(j) % mod) % mod)) %
            // mod;
            pairCount += hm.get(i) * hm.get(j);
            pairCount %= mod;
            i++;
            j--;
        }
        if ((B & 1) == 0) {
            // pairCount += ((hm.get(i) % mod * (((hm.get(i) % mod - 1 % mod) + mod) % mod)
            // % mod) % mod) / 2;
            pairCount += (hm.get(i) * (hm.get(i) - 1)) / 2;
            pairCount %= mod;
        }

        return (int) ((int) pairCount % mod);
    }

    public int solve1(int[] A, int B) {
        long cnt = 0;
        long mod = (long) (1e9 + 7);
        int N = A.length;
        int rem = 0;
        int[] arr = new int[B];
        for (int i = 0; i < B; i++) {
            arr[i] = 0;
        }
        for (int j = 0; j < N; j++) {
            rem = A[j] % B;
            arr[rem]++;
        }
        cnt += pairfind(arr[0]);
        int k = 1;
        int l = B - 1;
        if (B % 2 == 0) {
            cnt += pairfind(arr[B / 2]);
        }
        while (k < l) {
            cnt += (long) arr[k] * arr[l];
            k++;
            l--;
        }
        return (int) (cnt % mod);
    }

    public long pairfind(long a) {
        long sum = a * (a - 1) / 2;
        return sum;
    }

}

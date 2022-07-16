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
        int mod = 1000000007;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < B; i++) {
            hm.put(i, 0);
        }

        for (Integer i : A) {
            int remainder = i % B;
            hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);

        }
        int pairCount = ((hm.get(0) % mod * (hm.get(0) - 1) % mod) % mod) / 2;
        int i = 1, j = B - 1;
        while (i < j) {
            pairCount = (pairCount + ((hm.get(i) % mod * hm.get(j) % mod) % mod)) % mod;
            i++;
            j--;
        }
        if ((B & 1) == 0) {
            pairCount += ((hm.get(i) % mod * (hm.get(i) - 1) % mod) % mod) / 2;
        }

        return pairCount;
    }

}

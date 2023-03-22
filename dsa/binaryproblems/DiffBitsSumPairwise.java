package dsa.binaryproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffBitsSumPairwise {

    // 895503411 46485427
    public static void main(String[] args) {
        System.out.println(cntBits(new ArrayList<Integer>(Arrays.asList(new Integer[] { 7, 21, 25 }))));
    }

    static int cntBits(ArrayList<Integer> A) {
        int mod = 1000000007;
        long res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
        }

        int log = (int) (Math.log(max) / Math.log(2)) + 1;
        for (int i = 0; i < log; i++) {
            long count0 = 0;
            long count1 = 0;
            for (int j = 0; j < A.size(); j++) {
                if ((A.get(j) & (1 << i)) > 0) {
                    count1++;
                }
            }
            count0 = A.size() - count1;
            long totalPairs = count0 * count1 * 2;
            res = (res + totalPairs % mod) % mod;
        }

        return (int) res;
    }

}

package binaryproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffBitsSumPairwise {

    public static void main(String[] args) {
        System.out.println(cntBits(new ArrayList<Integer>(Arrays.asList(new Integer[] { 7, 21, 25 }))));
    }

    static int cntBits(ArrayList<Integer> A) {
        int mod = 1000000007;
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
        }

        int log = (int) (Math.log(max) / Math.log(2)) + 1;
        for (int i = 0; i < log; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = 0; j < A.size(); j++) {
                if (((A.get(j) >> i) & 1) == 1) {
                    count1++;
                } else {
                    count0++;
                }
            }
            long sum = (count0 % mod * count1 % mod * 2 % mod) % mod;
            res += sum;
        }

        return res;
    }

}

package hashing;

import java.util.HashSet;

public class SumWith0Sum {

    public int solve(int[] A) {
        int[] preSum = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            preSum[i] = sum;
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (Integer i : preSum) {
            if (set.contains(i)) {
                return 1;
            }
            set.add(i);
        }

        return 0;
    }

}

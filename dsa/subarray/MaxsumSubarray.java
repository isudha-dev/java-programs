package dsa.subarray;

import java.util.List;

public class MaxsumSubarray {
    public int maxSubArray(final List<Integer> A) {
        int n = A.size();
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += A.get(i);
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

}

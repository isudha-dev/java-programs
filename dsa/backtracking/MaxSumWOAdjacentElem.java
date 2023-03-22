package dsa.backtracking;

import java.util.Arrays;

public class MaxSumWOAdjacentElem {

    public static void main(String[] args) {
        MaxSumWOAdjacentElem max = new MaxSumWOAdjacentElem();
        System.out.println(max.adjacent(new int[][] { { 28 }, { 10 } }));
    }
    // 74, 38, 82, 1
    // 74, 74, 156, 156

    public int adjacent(int[][] A) {
        int[] newA = new int[A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            newA[i] = Math.max(A[0][i], A[1][i]);
        }
        if (newA.length == 1)
            return newA[0];

        int[] dp = new int[newA.length];
        Arrays.fill(dp, -1);
        dp[0] = newA[0];
        dp[1] = Math.max(newA[0], newA[1]);
        if (newA.length == 2)
            return dp[1];

        maxSum(newA, dp, dp.length - 1);

        return dp[dp.length - 1];
    }

    public int maxSum(int[] A, int[] dp, int i) {
        if (dp[i] != -1)
            return dp[i];

        int ans1 = A[i] + maxSum(A, dp, i - 2);
        int ans2 = maxSum(A, dp, i - 1);

        dp[i] = Math.max(ans1, ans2);
        return dp[i];
    }

}

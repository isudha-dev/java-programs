package dsa.dynamicprogramming;

public class CuttingARod {

    // Unbounded 0-1 knapsack
    public int solve(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= n; w++) {
                if (i <= w) {
                    dp[w] = Math.max(dp[w], A[i - 1] + dp[w - i]);
                }
            }
        }
        return dp[n];
    }
}

package dynamicprogramming;

import java.util.Arrays;

public class BuySellStocks3 {

    public static void main(String[] args) {
        BuySellStocks3 bs = new BuySellStocks3();
        bs.maxProfitDp(new int[] { 12, 14, 17, 10, 14, 13, 12, 15 }, 2);
        // 12, 14, 17, 10, 14, 13, 12, 15
    }

    // top down
    public int maxProfit(final int[] A) {
        int ans = maxProfitHelper(A, A.length - 1, 2);
        return ans;
    }

    public int maxProfitHelper(final int[] A, int len, int k) {
        if (len <= 0 || k == 0)
            return 0;
        int ans = maxProfitHelper(A, len - 1, k);
        for (int j = len - 1; j >= 0; j--) {
            ans = Math.max(ans, A[len] - A[j] + maxProfitHelper(A, j - 1, k - 1));
        }
        return ans;
    }

    // dp solution - doesnt work for large input
    public int maxProfitDp(final int[] A, int k) {
        int n = A.length;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = maxProfitDpHelper(k, n, A, dp);
        return ans;
    }

    int maxProfitDpHelper(int k, int len, int[] A, int[][] dp) {
        if (len <= 0 || k == 0)
            return 0;
        if (dp[k][len] != -1)
            return dp[k][len];

        dp[k][len] = maxProfitDpHelper(k, len - 1, A, dp);
        for (int j = len - 2; j >= 0; j--) {
            dp[k][len] = Math.max(dp[k][len], A[len - 1] - A[j] + dp[k - 1][j]);
        }
        return dp[k][len];
    }
}

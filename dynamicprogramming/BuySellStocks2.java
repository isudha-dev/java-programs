package dynamicprogramming;

import java.util.Arrays;

public class BuySellStocks2 {

    public static void main(String[] args) {
        BuySellStocks2 bs = new BuySellStocks2();
        bs.maxProfitDp(new int[] { 5, 2, 10 });
    }

    public int maxProfit(final int[] A) {
        int ans = maxProfitHelper(A, A.length - 1);
        return ans;
    }

    public int maxProfitHelper(final int[] A, int len) {
        if (len <= 0)
            return 0;
        int ans = maxProfitHelper(A, len - 1);
        for (int j = len - 1; j >= 0; j--) {
            ans = Math.max(ans, A[len] - A[j] + maxProfitHelper(A, j - 1));
        }
        return ans;
    }

    // dp solution - doesnt work for large input
    public int maxProfitDp(final int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxProfitDpHelper(n, A, dp);
    }

    int maxProfitDpHelper(int len, int[] A, int[] dp) {
        if (len <= 0)
            return 0;
        if (dp[len] != -1)
            return dp[len];

        dp[len] = maxProfitDpHelper(len - 1, A, dp);
        for (int j = len - 1; j >= 0; j--) {
            dp[len] = Math.max(dp[len], A[len] - A[j] + maxProfitDpHelper(j, A, dp));
        }
        return dp[len];
    }

    // simpler sol
    public int maxProfitSimple(final int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit = profit + (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    public int MaxProfitDp(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++)
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }

        return dp[2][prices.length - 1];
    }
}

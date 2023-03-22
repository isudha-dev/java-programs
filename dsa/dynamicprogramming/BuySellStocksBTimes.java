package dsa.dynamicprogramming;

public class BuySellStocksBTimes {

    public static void main(String[] args) {
        BuySellStocksBTimes bt = new BuySellStocksBTimes();
        int ans = bt.solve(new int[] { 13, 5, 1, 7 }, 1);
        System.out.println(ans);
        // 11, 7, 11, 17, 12, 12, 16, 10, 11 4
        // 19230, 13765, 6863, 3840, 8367, 15603, 16327, 15140, 5582, 12937, 9472,
        // 14190,
        // 9541, 4126,
        // 2757, 400, 19685, 15908, 4929, 18136, 16050, 6622, 13439, 265, 5846, 3188,
        // 8756, 4960, 18781, 11139,
        // 5152, 12314 },100000089

    }

    public int solve(int[] prices, int B) {
        if (prices.length == 0)
            return 0;
        int len = prices.length / 2;
        int[][] dp;
        if (B >= len) {
            dp = new int[len + 1][prices.length];
        } else {
            dp = new int[B + 1][prices.length + 1];
        }

        for (int k = 1; k <= B; k++) {
            int min = prices[0];
            if (k >= prices.length / 2) {
                return maxProfit(prices);
            }
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[B][prices.length - 1];
    }

    public int maxProfit(final int[] A) {
        int profit = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                profit = profit + (A[i] - A[i - 1]);
            }
        }
        return profit;
    }
}

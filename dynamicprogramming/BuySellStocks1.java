package dynamicprogramming;

public class BuySellStocks1 {
    public static void main(String[] args) {
        BuySellStocks1 bs = new BuySellStocks1();
        bs.maxProfit(new int[] { 5, 2, 10 });
    }

    // using right min val

    public int maxProfit(final int[] A) {
        int ans = 0;
        int rightMin = A[0];
        for (int i = 1; i < A.length; i++) {
            if (rightMin > A[i])
                rightMin = A[i];
            else
                ans = Math.max(ans, A[i] - rightMin);
        }
        return ans;
    }

}

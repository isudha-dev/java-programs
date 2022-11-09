package dynamicprogramming;

public class Knapsack2 {

    // Bounded 0-1 knapsack

    public static void main(String[] args) {
        Knapsack2 ks2 = new Knapsack2();
        ks2.solve1(new int[] { 6, 7, 3, 1 }, new int[] { 5, 4, 2, 2 }, 7);
    }

    public int solve(int[] A, int[] B, int C) {
        // A val
        // B weight
        // C knapsack capacity
        int n = A.length;
        int[][] dp = new int[C + 1][n + 1];

        for (int w = 1; w <= C; w++) {
            for (int len = 1; len <= n; len++) {
                dp[w][len] = dp[w][len - 1];
                if (B[len - 1] <= w) {
                    dp[w][len] = Math.max(dp[w][len], A[len - 1] + dp[w - B[len - 1]][len - 1]);
                }
            }
        }

        return dp[C][n];
    }

    // optimizing space
    public int solve1(int[] A, int[] B, int C) {
        // A val
        // B weight
        // C knapsack capacity
        int n = A.length;
        // int[][] dp = new int[C + 1][n + 1];
        int[] firstCol = new int[C + 1];
        int[] secondCol = new int[C + 1];

        for (int len = 1; len <= n; len++) {
            for (int w = 1; w <= C; w++) {
                // dp[w][len] = dp[w][len - 1];
                secondCol[w] = firstCol[w];
                if (B[len - 1] <= w) {
                    // dp[w][len] = Math.max(dp[w][len], A[len - 1] + dp[w - B[len - 1]][len - 1]);
                    secondCol[w] = Math.max(secondCol[w], A[len - 1] + firstCol[w - B[len - 1]]);
                }
            }
            for (int i = 0; i <= C; i++) {
                firstCol[i] = secondCol[i];
            }
        }

        // return dp[C][n];
        return secondCol[C];
    }

}

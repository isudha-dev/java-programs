package dynamicprogramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        MatrixChainMultiplication mc = new MatrixChainMultiplication();
        mc.solve(new int[] { 5, 4, 6, 2, 7 });
    }

    public int solve(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = len + i - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (A[i - 1] * A[k] * A[j]));
                }
            }
        }
        return dp[1][n - 1];
    }

}

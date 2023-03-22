package dsa.dynamicprogramming;

public class MinSumPathInMatrix {

    public static void main(String[] args) {
        MinSumPathInMatrix ms = new MinSumPathInMatrix();
        ms.minPathSum(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } });
    }

    public int minPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];

        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                dp[r][c] = -1;
            }
        }

        dp[0][0] = A[0][0];

        for (int i = 1; i < A[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + A[0][i];
        }

        for (int i = 1; i < A.length; i++) {
            dp[i][0] = dp[i - 1][0] + A[i][0];
        }

        return minPath(A.length - 1, A[0].length - 1, dp, A);
    }

    public int minPath(int i, int j, int[][] dp, int[][] A) {
        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = A[i][j] + Math.min(minPath(i - 1, j, dp, A), minPath(i, j - 1, dp, A));

        return dp[i][j];
    }

}

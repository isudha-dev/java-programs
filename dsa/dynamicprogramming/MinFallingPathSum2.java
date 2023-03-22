package dsa.dynamicprogramming;

public class MinFallingPathSum2 {

    public static void main(String[] args) {
        MinFallingPathSum2 min = new MinFallingPathSum2();
        min.solve(new int[][] { { 17, 14, 19 }, { 12, 18, 9 }, { 20, 10, 1 } });
    }

    public int solve(int[][] A) {
        int l1 = A.length;
        int l2 = A[0].length;

        int[][] dp = new int[l1][l2];

        for (int i = 0; i < l2; i++) {
            dp[l1 - 1][i] = A[l1 - 1][i];
        }

        for (int i = l1 - 2; i >= 0; i--) {
            for (int j = 0; j < l2; j++) {
                // find min on next row except when j == k
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < l2; k++) {
                    if (k == j)
                        continue;
                    min = Math.min(min, dp[i + 1][k]);
                }

                dp[i][j] = min + A[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < l2; i++)
            ans = Math.min(ans, dp[0][i]);

        return ans;
    }

}

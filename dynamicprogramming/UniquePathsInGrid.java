package dynamicprogramming;

import java.util.Arrays;

public class UniquePathsInGrid {
    public static void main(String[] args) {
        UniquePathsInGrid uq = new UniquePathsInGrid();
        uq.uniquePathsWithObstacles(new int[][] { { 1, 0 } });
    }

    public int uniquePathsWithObstacles(int[][] A) {
        if (A.length == 1 && A[0].length == 1) {
            if (A[0][0] == 0)
                return 1;
            if (A[0][0] == 1)
                return 0;
        }

        int[][] dp = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        if (A[0][0] == 1)
            dp[0][0] = 0;
        else
            dp[0][0] = 1;

        // fill 1st row
        for (int j = 1; j < A[0].length; j++) {
            if (A[0][j] == 1 || dp[0][j - 1] == 0)
                dp[0][j] = 0;
            else
                dp[0][j] = 1;
        }

        // fill 1st col
        for (int j = 1; j < A.length; j++) {
            if (A[j][0] == 1 || dp[j - 1][0] == 0)
                dp[j][0] = 0;
            else
                dp[j][0] = 1;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[A.length - 1][A[0].length - 1];
    }
}

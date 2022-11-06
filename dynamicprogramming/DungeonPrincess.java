package dynamicprogramming;

import java.util.Arrays;

public class DungeonPrincess {

    public static void main(String[] args) {
        DungeonPrincess ms = new DungeonPrincess();
        // ms.calMiniHP(new int[][] { { 1, -1, 0 }, { -1, 1, -1 }, { 1, 0, -1 } });
        ms.calMiniHP(new int[][] { { -10, -10 }, { -10, -10 } });
    }

    public int calMiniHP(int[][] A) {
        int l1 = A.length;
        int l2 = A[0].length;
        int dp[][] = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        dp[l1 - 1][l2] = 1;
        dp[l1][l2 - 1] = 1;

        for (int r = l1 - 1; r >= 0; r--) {
            for (int c = l2 - 1; c >= 0; c--) {
                int val = Math.min(dp[r + 1][c], dp[r][c + 1]) - A[r][c];
                if (val <= 0)
                    dp[r][c] = 1;
                else
                    dp[r][c] = val;
            }
        }

        return dp[0][0];
    }

    public int calMiniHP1(int[][] A) {
        int l1 = A.length;
        int l2 = A[0].length;
        int dp[][] = new int[l1 - 1][l2 - 1];
        dp[l1 - 1][l2 - 1] = A[l1 - 1][l2 - 1] > 0 ? 1 : Math.abs(A[l1 - 1][l2 - 1]) + 1;

        for (int r = l1 - 1; r >= 0; r--) {
            for (int c = l2 - 1; c >= 0; c--) {
                dp[r][c] = Math.min(dp[r + 1][c], dp[r][c + 1]) - A[r][c];
                if (dp[r][c] <= 0)
                    dp[r][c] = 1;
            }
        }

        return dp[0][0];
    }

}

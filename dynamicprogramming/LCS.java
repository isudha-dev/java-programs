package dynamicprogramming;

import java.util.Arrays;

public class LCS {

    public static void main(String[] args) {
        LCS ls = new LCS();
        System.out.println(ls.solve1("kbac", "lka"));
    }

    public int solve(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        // filling 1st row
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = 0;
        }

        // filling 1st col
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = 0;
        }

        // eariler 2 steps are not requires as array is by default initialized with 0s

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[l1][l2];
    }

    // we can optimize space, as we only need data from 2 rows. So we can maintain
    // just 2 rows, in form of 1D array.

    public int solve1(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();

        int[] firstRow = new int[l2 + 1];
        int[] secondRow = new int[l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    secondRow[j] = firstRow[j - 1] + 1;
                } else {
                    secondRow[j] = Math.max(secondRow[j - 1], firstRow[j]);
                }
            }
            for (int j = 1; j <= l2; j++) {
                firstRow[j] = secondRow[j];
            }
        }

        return secondRow[l2];
    }

}

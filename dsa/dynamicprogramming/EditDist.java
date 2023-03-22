package dsa.dynamicprogramming;

public class EditDist {

    public static void main(String[] args) {
        EditDist ed = new EditDist();
        System.out.println(ed.minDistance1("sunday", "saturday"));
    }

    public int minDistance(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        // 1st row, length of l2
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }

        // 1st col, length of l1
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(1 + dp[i - 1][j - 1], 1 + dp[i][j - 1]), 1 + dp[i - 1][j]);
                }
            }
        }

        return dp[l1][l2];
    }

    // we can optimize space, as we only need data from 2 rows. So we can maintain
    // just 2 rows, in form of 1D array.

    public int minDistance1(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();

        int[] firstRow = new int[l2 + 1];
        int[] secondRow = new int[l2 + 1];

        // 1st row, length of l2
        for (int i = 0; i <= l2; i++) {
            firstRow[i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            secondRow[0] = i;
            for (int j = 1; j <= l2; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    secondRow[j] = firstRow[j - 1];
                } else {
                    secondRow[j] = Math.min(Math.min(1 + firstRow[j - 1], 1 + secondRow[j - 1]), 1 + firstRow[j]);
                }
            }
            // copying second row to first
            for (int j = 0; j <= l2; j++) {
                firstRow[j] = secondRow[j];
            }
        }

        return secondRow[l2];
    }

}

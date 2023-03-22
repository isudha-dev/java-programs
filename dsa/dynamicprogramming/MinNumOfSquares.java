package dsa.dynamicprogramming;

import java.util.Arrays;

public class MinNumOfSquares {

    public static void main(String[] args) {
        MinNumOfSquares min = new MinNumOfSquares();
        System.out.println(min.countMinSquares(12));
    }

    public int countMinSquares(int A) {
        int arr[] = new int[A + 1];
        Arrays.fill(arr, -1);
        int res = countSquares(A, arr);

        return res;
    }

    int countSquares(int A, int[] dp) {
        if (A <= 3)
            return A;

        if (dp[A] != -1)
            return dp[A];

        int ans = A;

        for (int i = 1; i * i <= A; i++) {
            int temp = 1 + countSquares(A - i * i, dp);
            ans = Math.min(ans, temp);

        }
        dp[A] = ans;

        return ans;
    }
}

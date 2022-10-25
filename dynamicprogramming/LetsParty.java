package dynamicprogramming;

import java.util.Arrays;

public class LetsParty {

    public int solve(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);

        return helper(A, dp);
    }

    public int helper(int A, int[] dp) {
        if (A == 1 || A == 2) {
            return A;
        }
        if (dp[A] != -1) {
            return dp[A];
        }

        int mod = 10003;
        dp[A] = (helper(A - 1, dp) % mod + (helper(A - 2, dp) % mod * (A - 1) % mod) % mod) % mod;
        return dp[A];
    }

}

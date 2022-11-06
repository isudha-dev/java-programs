package dynamicprogramming;

public class DiceThrows {

    public int solve(int N) {

        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[i] = 0;
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] % 1000000007 + dp[i - j] % 1000000007) % 1000000007;
                }
            }
        }
        return dp[N];

    }

}

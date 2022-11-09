package dynamicprogramming;

import java.util.Arrays;

public class RussianDollEnvelops {

    public int solve(int[][] A) {
        // 2D array sorting using comparator
        Arrays.sort(A, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return Integer.compare(e2[1], e1[1]);
            } else {
                return Integer.compare(e1[0], e2[0]);
            }
        });

        int n = A.length;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j][0] < A[i][0] && A[j][1] < A[i][1])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}

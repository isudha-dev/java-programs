package dsa.practise;

// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
public class MinDeleteSumOf2Strings {

    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for(int i = 0; i <= l1; i++) {
            for(int j  = 0; j <= l2; j++) {
                if(i == 0 || j == 0) {
                    int a = 0;
                    if(i == 0) {
                        for(int k = 0; k < j; k++) {
                            a += s2.charAt(k);
                        }
                    } else {
                        for(int k = 0; k < j; k++) {
                            a += s1.charAt(k);
                        }
                    }
                    dp[i][j] = a;
                } else if (s1.charAt(i-1) == s1.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i-1)+dp[i-1][j], s2.charAt(j-1)+dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j], s1.charAt(i)+s2.charAt(j)+dp[i-1][j-1]);
                }
            }
        }

        return dp[l1][l2];
    }

}

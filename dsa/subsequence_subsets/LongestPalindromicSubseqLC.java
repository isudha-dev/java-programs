package dsa.subsequence_subsets;

public class LongestPalindromicSubseqLC {

    public static void main(String[] args) {
        longestPalindromeSubseq("bbbab");
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

//        for (int i = 0; i < n; i++){
//            for(int j = 0; j< n; j++){
//                dp[i][j] = -1;
//            }
//        }

        for(int j = 0; j< n; j++){
            dp[j][j] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = len + i - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

//        for(int i = 0; i < n-1; i++){
//            for(int j = n-1; j>=1; j--){
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = 2 + dp[i + 1][j - 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
//                }
//            }
//        }

        return dp[0][n-1];
    }

    public static int lps(String s, int i, int j){
        if(i > j) return 0;
        if(i == j) return 1;

        if(s.charAt(i) == s.charAt(j)){
            return 2 + lps(s, i+1, j-1);
        } else {
            return Math.max(lps(s, i, j-1), lps(s,i+1,j));
        }
    }

}

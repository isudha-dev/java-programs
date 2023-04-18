package dsa.dynamicprogramming;

// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/
public class NoOfWaysToFormTargetInADictionaryLC {

    public static void main(String[] args) {
        String[] words = new String[] {"acca","bbbb","caca"};
        String target = "aba";
        numWays(words, target);
    }

    public static int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = words.length;
        int k = target.length();

        int[][] count = new int[n][26];
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                count[j][words[i].charAt(j) - 'a']++;
            }
        }

        long dp[][] = new long[n+1][k+1];
        for(int i = 0; i <= n; i++ ){
            for(int j = 0; j <= k; j++ ){
                dp[i][j] = -1;
            }
        }

        return (int) dp(words, target, 0,0, dp, count);

    }

    public static long dp(String[] words, String target, int i, int j, long dp[][], int count[][]){
        long mod = 1000000007;
        if (j >= target.length()){
            return 1;
        }
        if (i >= words[0].length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        long inc = 0l, exc = 0l;

        if(count[i][target.charAt(j)-'a'] != 0){
            inc = (count[i][target.charAt(j)-'a'] * dp(words, target,i+1, j+1, dp, count)) % mod;
        }

        exc = dp(words, target, i+1, j, dp, count) % mod;

        dp[i][j] = (int) ((inc+exc)%mod);
        return dp[i][j];
    }

}

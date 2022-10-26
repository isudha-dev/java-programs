package backtracking;

public class WaysToDecode {

    public static void main(String[] args) {
        WaysToDecode wd = new WaysToDecode();
        System.out.println(wd.numDecodings("0"));
    }

    public int numDecodings(String A) {
        int mod = 1000000007;
        if (A.isEmpty())
            return 0;

        if (A.charAt(0) <= '0')
            return 0;

        int[] dp = new int[A.length() + 1];
        dp[0] = 1; // denoting for emprty string
        dp[1] = 1; // denoting for single char valid string

        for (int i = 2; i <= A.length(); i++) {
            if (A.charAt(i - 1) >= '1' && A.charAt(i - 1) <= '9')
                dp[i] = dp[i - 1];
            if (A.charAt(i - 2) == '1')
                dp[i] = (dp[i] % mod + dp[i - 2] % mod) % mod;
            else if (A.charAt(i - 2) == '2' && (A.charAt(i - 1) >= '0' && A.charAt(i - 1) <= '6'))
                dp[i] = (dp[i] % mod + dp[i - 2] % mod) % mod;

        }

        return dp[A.length()];
    }

}

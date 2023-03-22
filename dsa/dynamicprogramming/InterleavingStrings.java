package dsa.dynamicprogramming;

public class InterleavingStrings {

    // dp with 3 params
    public static void main(String[] args) {
        InterleavingStrings is = new InterleavingStrings();
        is.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    public int isInterleave(String A, String B, String C) {

        int l1 = A.length();
        int l2 = B.length();
        int l3 = C.length();
        if (l3 != l1 + l2)
            return 0;

        if (l1 == 0 && l2 == 0 && l3 == 0)
            return 1;

        int[][][] dp = new int[l1 + 1][l2 + 1][l3 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                for (int k = 0; k <= l3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return isInterleaveHelp(A, B, C, dp);
    }

    public int isInterleaveHelp(String A, String B, String C, int[][][] dp) {
        int l1 = A.length();
        int l2 = B.length();
        int l3 = C.length();
        if (l3 != l1 + l2)
            return 0;

        if (l1 == 0 && l2 == 0 && l3 == 0)
            return 1;

        if (dp[l1][l2][l3] != -1)
            return dp[l1][l2][l3];

        int ans = 0, ans1 = 0, ans2 = 0;
        if (l1 > 0 && A.charAt(0) == C.charAt(0)) {
            ans1 = isInterleaveHelp(A.substring(1, l1), B, C.substring(1, l3), dp);
        }
        if (l2 > 0 && B.charAt(0) == C.charAt(0)) {
            ans2 = isInterleaveHelp(A, B.substring(1, l2), C.substring(1, l3), dp);
        }
        ans = (ans1 == 1 || ans2 == 1) ? 1 : 0;

        dp[l1][l2][l3] = ans;

        return ans;
    }

}

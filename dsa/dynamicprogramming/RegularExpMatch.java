package dsa.dynamicprogramming;

public class RegularExpMatch {

    public static void main(String[] args) {
        RegularExpMatch re = new RegularExpMatch();
        System.out.println(re.isMatchDpOpt("aabbaaabbbaa", "a*bbb*aaa"));
    }

    public int isMatch(final String A, final String B) {

        int l1 = A.length();
        int l2 = B.length();

        if (l1 == 0 && l2 == 0)
            return 1;
        if (l2 == 0)
            return 0;
        if (l1 == 0) {
            for (int i = 0; i < l2; i++) {
                if (B.charAt(i) != '*')
                    return 0;
            }
            return 1;
        }

        if ((B.charAt(l2 - 1) == '?') || (B.charAt(l2 - 1) == A.charAt(l1 - 1))) {
            return isMatch(A.substring(0, l1 - 1), B.substring(0, l2 - 1));
        } else if (B.charAt(l2 - 1) == '*') {
            int c1 = isMatch(A.substring(0, l1), B.substring(0, l2 - 1));
            int c2 = isMatch(A.substring(0, l1 - 1), B.substring(0, l2));
            return (c1 == 1 || c2 == 1) ? 1 : 0;
        } else {
            return 0;
        }
    }

    // dp solution
    public int isMatchDp(final String A, final String B) {
        int l1 = A.length();
        int l2 = B.length();

        int[][] dp = new int[l1 + 1][l2 + 1];
        // "" "" is always a match
        dp[0][0] = 1;

        // filling 1st row
        for (int i = 1; i <= l2; i++) {
            if (B.charAt(i - 1) == '*')
                dp[0][i] = 1;
            else
                break;
        }

        // // filling 1st col with 0 not needed here because of default initialization
        // for (int i = 1; i < l1; i++) {
        // dp[i][0] = 0;
        // }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (B.charAt(j - 1) == '*') {
                    int c1 = dp[i][j - 1];
                    int c2 = dp[i - 1][j];
                    dp[i][j] = (c1 == 1 || c2 == 1) ? 1 : 0;
                }
            }
        }
        return dp[l1][l2];
    }

    // using 2, 1D array instead of dsa.matrix of l1*l2

    public int isMatchDpOpt(final String A, final String B) {
        int l1 = A.length();
        int l2 = B.length();

        int[] firstRow = new int[l2 + 1];
        int[] secondRow = new int[l2 + 1];

        // "" "" is always a match
        firstRow[0] = 1;

        // filling 1st row
        for (int i = 1; i <= l2; i++) {
            if (B.charAt(i - 1) == '*')
                firstRow[i] = 1;
            else
                break;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '?')
                    secondRow[j] = firstRow[j - 1];
                else if (B.charAt(j - 1) == '*') {
                    secondRow[j] = (firstRow[j] == 1 || secondRow[j - 1] == 1) ? 1 : 0;
                } else {
                    secondRow[j] = 0;
                }
            }
            firstRow[0] = 0;
            int[] temp = firstRow;
            firstRow = secondRow;
            secondRow = temp;
        }
        return firstRow[l2];
    }

}

package dsa.palindrome;

public class largestPdString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    static String longestPalindrome(String s) {
        int n = s.length();
        String retStr = "";
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            String tempStr = s.substring(0, i + 1);
            if (isPalindrome(tempStr.split(""), 0, i)) {
                if (tempStr.length() > maxLen) {
                    maxLen = tempStr.length();
                    retStr = tempStr;
                }

            }

        }

        return retStr;
    }

    static boolean isPalindrome(String[] s, int i, int j) {
        if (j == i + 1)
            return (s[i].equals(s[j]));
        else if (i != j && j != i + 1) {
            return isPalindrome(s, i + 1, j - 1) && (s[i].equals(s[j]));
        } else
            return true;
    }

}

package dsa.strings;

public class LongestPalindromicSs {

    public static void main(String[] args) {
        System.out.println(maxPalinSubstring("gyzxabcbaxzygvjkfkcyttyckftf"));
    }

    static String maxPalinSubstring(String str) {

        int n = str.length();
        String output = "";
        int ans = 0;

        // for odd length substring
        for (int i = 0; i < n; i++) {
            int p1 = i, p2 = i;
            String ansStr = expandAndFindLen(str, p1, p2);
            if (ansStr.length() > ans) {
                ans = ansStr.length();
                output = ansStr;
            }
        }

        // for even length substring
        for (int i = 0; i < n - 1; i++) {
            int p1 = i, p2 = i + 1;
            String ansStr = expandAndFindLen(str, p1, p2);
            if (ansStr.length() > ans) {
                ans = ansStr.length();
                output = ansStr;
            }
        }
        return output;
    }

    static String expandAndFindLen(String str, int p1, int p2) {
        String ansStr = "";
        char[] chStr = str.toCharArray();
        while (p1 >= 0 && p2 < str.length()) {
            if (chStr[p1] != chStr[p2]) {
                break;
            }
            ansStr = str.substring(p1, p2 + 1);
            p1--;
            p2++;
        }
        return ansStr;
    }

}

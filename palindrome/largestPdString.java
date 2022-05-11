package palindrome;

import java.util.HashMap;
import java.util.Map;

public class largestPdString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    static String longestPalindrome(String s) {
        int n = s.length();
        String retS = s;
        int maxLen = 0;
        Map<Integer, Integer> prvPd = new HashMap<>();

        // int lenToBeChecked = n - 1;
        for (int i = 0; i < n - 1; i++) {// && lenToBeChecked >= maxLen
            int j = i + 1;
            // lenToBeChecked = n - 2;
            while (j <= n) { // && lenToBeChecked >= maxLen
                boolean isPD = isPalindrome(s.substring(i, j));
                if (isPD) {
                    int len = s.substring(i, j).length();
                    prvPd.put(i, len);
                    if (len > maxLen)
                        maxLen = len;
                    if (maxLen == n) {
                        return retS;
                    }
                    j += 2;
                    // lenToBeChecked -= 2;
                } else {
                    j++;
                    // lenToBeChecked -= 1;
                }

            }
            // lenToBeChecked -= 1;
        }

        for (Map.Entry<Integer, Integer> en : prvPd.entrySet()) {
            if (en.getValue() == maxLen) {
                retS = s.substring(en.getKey(), en.getKey() + maxLen);
                return retS;
            }

        }
        return retS;

    }

    static boolean isPalindrome(String s) {
        int n = s.length();
        String[] strArr = s.split("");
        for (int i = 0; i <= n / 2; i++) {
            int j = n - 1 - i;
            if (!strArr[i].equals(strArr[j])) {
                return false;
            }

        }

        return true;
    }

}

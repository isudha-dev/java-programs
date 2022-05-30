package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(
                longestCommonPrefix(
                        new ArrayList<String>(Arrays.asList(new String[] { "abcd", "ab", "abab" }))));

    }

    static String longestCommonPrefix(ArrayList<String> A) {
        int idx = 0;
        int minLen = Integer.MAX_VALUE;
        boolean mismatch = false;

        for (String s : A) {
            minLen = Math.min(s.length(), minLen);
        }

        while (idx < minLen && !mismatch) {
            char s1 = A.get(0).charAt(idx);
            for (int i = 1; i < A.size(); i++) {
                char s2 = A.get(i).charAt(idx);
                if (s2 != s1) {
                    mismatch = true;
                    break;
                }
            }
            idx++;
        }

        String ans;
        if (idx == minLen) {
            ans = A.get(0).substring(0, idx);
        } else {
            ans = A.get(0).substring(0, idx - 1);
        }

        return ans;
    }
}

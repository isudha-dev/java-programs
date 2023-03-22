package dsa.strings;

import java.util.Arrays;

public class PermOfAInB {

    public static void main(String[] args) {
        System.out.println(solve("abc", "abcbacabc"));
    }

    public static int solve(String A, String B) {
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for (Character c : A.toCharArray()) {
            freqA[c - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            freqB[B.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freqA, freqB)) {
            count++;
        }

        for (int i = 1; i <= B.length() - A.length(); i++) {
            freqB[B.charAt(i - 1) - 'a']--;
            freqB[B.charAt(A.length() + i - 1) - 'a']++;
            if (Arrays.equals(freqA, freqB)) {
                count++;
            }
        }

        return count;
    }

}

package strings;

import java.util.HashMap;

// Given 2 string A & B of length M & N (M>=N). Count substrings of A, that are anagram of B
public class SubstringAnagram {

    public static void main(String[] args) {
        System.out.println(substringAnagram("abcaccbabcacab", "abacc"));
    }

    static int substringAnagram(String A, String B) {
        int count = 0;
        HashMap<Character, Integer> hA = new HashMap<>();
        HashMap<Character, Integer> hB = new HashMap<>();

        char[] chStrB = B.toCharArray();
        for (char c : chStrB) {
            if (hB.containsKey(c)) {
                int freq = hB.get(c) + 1;
                hB.put(c, freq);
            } else {
                hB.put(c, 1);
            }
        }

        char[] chStrA = A.substring(0, 5).toCharArray();
        for (char c : chStrA) {
            if (hA.containsKey(c)) {
                int freq = hA.get(c) + 1;
                hA.put(c, freq);
            } else {
                hA.put(c, 1);
            }
        }

        if (hA.equals(hB)) {
            count++;
        }

        chStrA = A.toCharArray();
        for (int i = 1; i <= A.length() - B.length(); i++) {
            char prevCh = chStrA[i - 1];
            char nextCh = chStrA[i + 4];

            if (hA.containsKey(prevCh)) {
                int freq = hA.get(prevCh) - 1;
                hA.put(prevCh, freq);
            } else {
                hA.put(prevCh, 1);
            }

            if (hA.containsKey(nextCh)) {
                int freq = hA.get(nextCh) + 1;
                hA.put(nextCh, freq);
            } else {
                hA.put(nextCh, 1);
            }

            if (hA.equals(hB)) {
                count++;
            }

        }

        return count;
    }

}

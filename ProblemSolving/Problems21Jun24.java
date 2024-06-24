package ProblemSolving;

import dsa.strings.ZAlgo;

import java.util.*;

public class Problems21Jun24 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("AaaA");

    }

    /*
        abcabcbb

     */
    public static int lengthOfLongestSubstring(String A) {
        int maxLen = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int p1 = 0, p2 = 0;

        while(p2<A.length()){
            char c = A.charAt(p2);
            if(!set.contains(c)){
                set.add(c);
                maxLen = Math.max(maxLen, p2-p1+1);
                p2++;
            } else {
                while (A.charAt(p1) != c){
                    set.remove(A.charAt(p1));
                    p1++;
                }
                set.remove(A.charAt(p1));
                p1++;
                set.add(c);
                p2++;
            }
        }

        return maxLen;
    }

    public static String minWindow(String A, String B) {
        if (A.isEmpty() || A.length() < B.length()) {
            return "";
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        for (Character c: B.toCharArray()) {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        int mcnt = 0;
        int start = 0;
        int minlength = Integer.MAX_VALUE;
        int minleft = 0;
        for (int i = 0; i < A.length(); i++) {

            if (hm.containsKey(A.charAt(i))) {
                hm.put(A.charAt(i), hm.get(A.charAt(i)) - 1);
                if (hm.get(A.charAt(i)) >= 0) {
                    mcnt++;//got eligible character
                }
            }

            while (mcnt == B.length())//got eligible window
            {
                //save length
                if (minlength > (i - start + 1)) {
                    minlength = i - start + 1;
                    minleft = start;
                }
                //remove
                if (hm.containsKey(A.charAt(start))) {
                    hm.put(A.charAt(start), hm.get(A.charAt(start)) + 1);
                    if (hm.get(A.charAt(start)) > 0) {
                        mcnt--;
                    }
                }
                start++;
            }
        }
        if (minlength > A.length()) {
            return "";
        }
        return A.substring(minleft, minleft + minlength);
    }

    public static int perm(String A, String B) {
        int n = A.length();
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for (Character c : A.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            mapB.put(B.charAt(i), mapB.getOrDefault(B.charAt(i), 0) + 1);
        }

        int count = 0;
        if (mapA.equals(mapB)) {
            count++;
        }

        for (int i = n; i < B.length(); i++) {
            int idx = i - n;
            char c = B.charAt(idx);

            //remove
            if (mapB.get(c) == 1) {
                mapB.remove(c);
            } else {
                mapB.put(c, mapB.get(c) - 1);
            }

            //add
            mapB.put(B.charAt(i), mapB.getOrDefault(B.charAt(i), 0) + 1);

            if (mapA.equals(mapB)) {
                count++;
            }
        }


        return count;
    }

    public static int boringSubstring(String A) {
        ArrayList<Character> evenChar = new ArrayList<>();
        ArrayList<Character> oddChar = new ArrayList<>();

        for (Character c : A.toCharArray()) {
            if (c % 2 == 0) {
                evenChar.add(c);
            } else {
                oddChar.add(c);
            }
        }

        Collections.sort(evenChar);
        Collections.sort(oddChar);

        ArrayList<Character> arrangedStr = new ArrayList<>();
        arrangedStr.addAll(evenChar);
        arrangedStr.addAll(oddChar);

        for (int i = 0; i < arrangedStr.size() - 1; i++) {
            if (Math.abs(arrangedStr.get(i) - arrangedStr.get(i + 1)) == 1) {
                return 0;
            }
        }

        return 1;
        /*
            a  b  c  d
            97 98 99 100
            c  a  d  b
            99 97 100 98
            b  d   a  c
            98 100 97 99

            a  a  b
            97 97 98
         */

    }

    public static int makeStringPalindrome(String A) {
        int n = A.length();
        int p1 = 0;
        int p2 = 0;

        int count = 0;
        while (p1 < p2) {
            if (A.charAt(p1) != A.charAt(p2)) {
                count++;
                p2--;
            }
        }

        /*
            abab
            babab

            cabbc => cbba
            cabbc#cbbac
            00001010011




        */
        return count;
    }

    public static String smallestPrefix(String A, String B) {

        int p1 = 1;
        int p2 = 0;

        StringBuilder sb = new StringBuilder();
        char c = A.charAt(0);
        sb.append(c);

        while (p1 < A.length()) {
            char s = A.charAt(p1);
            if (s < B.charAt(p2)) {
                sb.append(s);
                p1++;
            } else {
                break;
            }

        }


        char s = B.charAt(p2);
        if (c <= s) {
            sb.append(s);
        }

        return sb.toString();
    }


    public static int solve(String A) {

        List<Integer> zAlgoArr = ZAlgo.zAlgo(A);
        for (int i = 1; i < A.length(); i++) {
            if (i + zAlgoArr.get(i) == A.length()) {
                return i;
            }

        }
        return A.length();
    }

    public static String closestPalin(String A) {
        int n = A.length();
        int p1 = 0;
        int p2 = n - 1;

        int mismatch = 0;
        while (p1 < p2 && mismatch <= 1) {
            if (A.charAt(p1) != A.charAt(p2)) {
                mismatch++;
            }
            p1++;
            p2--;
        }

        // palindrome with 1 char in middle
        if (mismatch == 0) {
            if (p1 == p2) {
                return "YES";
            } else {
                return "NO";
            }
        } else if (mismatch == 1) {
            return "YES";
        } else {
            return "NO";
        }

    }


}

package dsa.strings;

// https://leetcode.com/problems/merge-strings-alternately/
public class MergeAlternatelyLC {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();

        int n = 1;
        while(n <= word1.length() && n <= word2.length()){
            sb.append(word1.charAt(n-1));
            sb.append(word2.charAt(n-1));
            n++;
        }
        while (n <= word1.length()){
            sb.append(word1.charAt(n-1));
            n++;
        }
        while (n <= word2.length()){
            sb.append(word2.charAt(n-1));
            n++;
        }

        return sb.toString();
    }

}

package dsa.practise;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict){
        if (s == null || s.length() == 0) return false;

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println( wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    /*
        assumption:
        magic method that checks if given string s, matches with any of words in wordDict. returns boolean

        base case:
        if(s.length() == 0) {
            return true;
        }
        i(wordDict.size() == 0) {
            return false;
       }

       main logic:
       1. pick a word from dict
       2. match that word with s upto word length
       3. if(match found) -> call the method with remaining length of s and wordDict.
       4. if(not found) -> call the method again with same s but removing 1st word from wordDict.
     */

}

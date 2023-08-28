package dsa.contest.july08.tct1ReAttempt;

import java.util.HashSet;

public class LongestSSWithKDistinctChar {

    // o(n^2) solution
    public static int solve(String A, int B) {
        if(A.length() == 0 || B == 0) {
            return 0;
        }

        char[] chArr = A.toCharArray();
        int n = chArr.length;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            HashSet<Character> set = new HashSet<>();
            set.add(chArr[i]);
            int j = i+1;
            while (j < n ){
                set.add(chArr[j]);
                if(set.size() > B){
                    break;
                }
                j++;
            }
            int end = j == n ? j: j-1;
            maxLen = Math.max(maxLen, j-i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println( solve("beedcface",4));
    }
}

package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;

public class Problems_17Apr24_17May24 {
    public static void main(String[] args) {
//        System.out.println(rearrangeToPalindrome("abbaeek"));
        System.out.println(subarrayWithBOddNums(new int[]{5, 6, 7, 8, 9, 1, 2, 4, 6, 5, 9, 2, 7, 2}, 3));
    }

    public static int rearrangeToPalindrome(String A) {
        int[] chars = new int[26];

        for(int i = 0; i<A.length(); i++){
            char c = A.charAt(i);
            chars[c - 'a']++;
        }

        int oddCount = 0;

        for(int i: chars){
            if(i%2 != 0)
                oddCount++;
        }

        if(oddCount > 1){
            return 0;
        }

        return 1;

    }

    public static int subarrayWithBOddNums(int[] a, int m) {
        /*
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14
            2, 5, 6, 7, 8, 9, 1, 2, 4, 6, 5, 9, 2, 7, 2
            e  o  e  o  e  o  o  e  e  e  o  o  e  o  e
            3
            17
            start   1 3 5  6  10
            end     5 6 10 11 13
         prev odd  -1 1 3  5  6
         even nums  1 1 1  0  3
         next odd   3 5 6  10 -1

                    2 2 2  1  4 1
            cnt     1 1 1 1 1 1 1  1  1  1
            cntf    1 1 1 1 1 1 0  0  3  3
         */


        int n = a.length;
        int count = 0;
        int[] prefix = new int[n + 1];
        int odd = 0;

        // Traverse in the array
        for (int j : a) {
            prefix[odd]++;

            // If array element is odd
            if ((j & 1) == 1)
                odd++;

            // When number of odd
            // elements >= M
            if (odd >= m)
                count += prefix[odd - m];
        }

        return count;
    }
}

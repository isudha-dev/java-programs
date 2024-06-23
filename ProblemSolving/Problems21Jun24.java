package ProblemSolving;

import dsa.strings.ZAlgo;

import java.util.List;

public class Problems21Jun24 {
    public static void main(String[] args) {
        closestPalin("cddfeffe");

    }

    public static int makeStringPalindrome(String A) {
        int n = A.length();
        int p1 = 0;
        int p2 = 0;

        int count = 0;
        while(p1<p2){
            if(A.charAt(p1) != A.charAt(p2)){
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

        while (p1<A.length()){
            char s = A.charAt(p1);
            if(s < B.charAt(p2)){
                sb.append(s);
                p1++;
            } else {
                break;
            }

        }


        char s = B.charAt(p2);
        if(c <= s){
            sb.append(s);
        }

        return sb.toString();
    }


    public static int solve(String A) {

        List<Integer> zAlgoArr = ZAlgo.zAlgo(A);
        for (int i = 1; i < A.length(); i++) {
            if(i+ zAlgoArr.get(i) == A.length()){
                return i;
            }

        }
        return A.length();
    }

    public static String closestPalin(String A) {
        int n = A.length();
        int p1 = 0;
        int p2 = n-1;

        int mismatch = 0;
        while(p1<p2 && mismatch <= 1){
            if(A.charAt(p1) != A.charAt(p2)){
                mismatch++;
            }
            p1++;
            p2--;
        }

        // palindrome with 1 char in middle
        if(mismatch == 0){
            if(p1==p2 ){
                return "YES";
            } else {
                return "NO";
            }
        } else if(mismatch == 1) {
            return "YES";
        } else {
            return "NO";
        }

    }


}

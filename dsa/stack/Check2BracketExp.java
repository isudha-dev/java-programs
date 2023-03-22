package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class Check2BracketExp {

    public static void main(String[] args) {
        System.out.println(solve("-(a+((b-c)-(d+e)))", "-(a+b-c-d-e)"));
    }

    // "(a+b-c-d+e-f+g+h+i)", "a+b-c-d+e-f+g+h+i"
    // "-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q"
    public static int solve(String A, String B) {

        boolean[] arrA = simplifiedExp(A);
        boolean[] arrB = simplifiedExp(B);

        return Arrays.equals(arrA, arrB) ? 1 : 0;
    }

    public static boolean[] simplifiedExp(String s) {
        boolean[] charArr = new boolean[26];

        Stack<Boolean> gSignStack = new Stack<>();
        gSignStack.push(true);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!adjSign(s, i))
                    gSignStack.push(!gSignStack.peek());
                else
                    gSignStack.push(gSignStack.peek());
                continue;
            }
            if (s.charAt(i) == ')') {
                gSignStack.pop();
                continue;
            }
            if (s.charAt(i) != '+' && s.charAt(i) != '-') {
                if (gSignStack.peek())
                    charArr[s.charAt(i) - 'a'] = adjSign(s, i);
                else
                    charArr[s.charAt(i) - 'a'] = !adjSign(s, i);
            }
        }

        return charArr;
    }

    public static Boolean adjSign(String s, int i) {
        if (i == 0) {
            return true;
        }
        char prevChar = s.toCharArray()[i - 1];
        boolean ans = true;
        if (prevChar == '-') {
            ans = false;
        }
        return ans;
    }

}

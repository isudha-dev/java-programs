package stack;

import java.util.Stack;

public class BalancedParentheses1 {

    public static void main(String[] args) {
        System.out.println(solve("(()(()(()"));
    }

    static int solve(String A) {
        char[] chArr = A.toCharArray();

        Stack<Character> stk = new Stack<Character>();

        for (Character ch : chArr) {
            if (ch == '(') {
                stk.add(ch);
            } else if (stk.isEmpty()) {
                return 0;
            } else {
                stk.pop();
            }

        }

        return stk.size() == 0 ? 1 : 0;
    }

}

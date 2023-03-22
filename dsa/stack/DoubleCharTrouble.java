package dsa.stack;

import java.util.Stack;

public class DoubleCharTrouble {

    public static void main(String[] args) {
        System.out.println(solve("abcdeedcaabxxdad"));
    }

    public static String solve(String A) {
        Stack<Character> stk = new Stack<Character>();
        for (Character c : A.toCharArray()) {
            if (!stk.empty() && stk.peek().equals(c)) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        StringBuffer ans = new StringBuffer();
        while (!stk.empty()) {
            ans.append(stk.pop());
        }
        ans.reverse();

        return ans.toString();
    }
}

package stack;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        System.out.println(braces("(a+((b*c)+c))"));
    }

    // (a+((b*c)+c))
    public static int braces(String A) {
        Stack<Character> stk = new Stack<>();
        for (Character c : A.toCharArray()) {
            if (c == '(') {
                stk.push(c);
                continue;
            }
            if (c == '+' || c == '*' || c == '-' || c == '/') {
                stk.push(c);
                continue;
            }
            if (c == ')') {
                Character c1 = stk.peek();
                if (c1 != '+' && c1 != '*' && c1 != '-' && c1 != '/') {
                    return 1;
                }
                while (c1 == '+' || c1 == '*' || c1 == '-' || c1 == '/') {
                    stk.pop();
                    c1 = stk.peek();
                }
                if (stk.peek() == '(') {
                    stk.pop();
                } else {
                    return 1;
                }
            }
        }

        return 0;
    }

}

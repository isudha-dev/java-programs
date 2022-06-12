package stack;

import java.util.LinkedList;

public class BalancedParentheses2 {
    public static void main(String[] args) {
        System.out.println(solve("({)}"));
    }

    static int solve(String A) {
        LinkedList<Character> ll = new LinkedList<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                ll.add(ch);
            } else if (ll.isEmpty()) {
                return 0;
            } else {
                if (ch == ')' && ll.getLast() == '(') {
                    ll.removeLast();
                } else if (ch == '}' && ll.getLast() == '{') {
                    ll.removeLast();
                } else if (ch == ']' && ll.getLast() == '[') {
                    ll.removeLast();
                } else {
                    return 0;
                }
            }
        }

        return ll.isEmpty() ? 1 : 0;
    }

}

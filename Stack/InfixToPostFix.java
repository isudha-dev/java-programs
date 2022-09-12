package stack;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        System.out.println(solve("q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)"));
    }

    public static String solve(String A) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = buildPrecisionMap();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // pop out opening bracket -> '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!stack.isEmpty() && stack.peek() != '(' && map.get(c) <= map.get(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static HashMap<Character, Integer> buildPrecisionMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('/', 2);
        map.put('*', 2);
        map.put('^', 3);
        return map;
    }
}

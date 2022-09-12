package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExp {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList(new String[] { "4", "13", "5", "/", "+", "12", "6", "/", "-" }));
        System.out.println(evalRPN1(list));

    }

    public static int evalRPN(ArrayList<String> A) {
        Stack<String> op1 = new Stack<>();
        Stack<String> op2 = new Stack<>();
        Stack<String> ops = new Stack<>();
        Stack<String> ans = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            String s = A.get(i);
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // ops.add(s);
                int o1 = op1.isEmpty() ? Integer.parseInt(ans.pop()) : Integer.parseInt(op1.pop());

                continue;
            }
            String sNext = A.get(i + 1);
            if (sNext.equals("+") || sNext.equals("-") || sNext.equals("*") || sNext.equals("/")) {
                op2.add(s);
            } else {
                op1.add(s);
            }
        }

        while (!ops.isEmpty()) {
            int o1 = Integer.parseInt(op1.pop());
            int o2 = Integer.parseInt(op2.pop());
            if (ops.pop().equals("+")) {
                op2.push(Integer.toString(o1 + o2));
            } else if (ops.pop().equals("-")) {
                op2.push(Integer.toString(o1 - o2));
            } else if (ops.pop().equals("*")) {
                op2.push(Integer.toString(o1 * o2));
            } else {
                op2.push(Integer.toString(o1 / o2));
            }
        }

        return Integer.parseInt(op2.pop());
    }

    public static int evalRPN1(ArrayList<String> A) {
        Stack<String> oprands = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            String s = A.get(i);
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int o2 = Integer.parseInt(oprands.pop());
                int o1 = Integer.parseInt(oprands.pop());
                if (s.equals("+")) {
                    oprands.push(Integer.toString(o1 + o2));
                } else if (s.equals("-")) {
                    oprands.push(Integer.toString(o1 - o2));
                } else if (s.equals("*")) {
                    oprands.push(Integer.toString(o1 * o2));
                } else {
                    oprands.push(Integer.toString(o1 / o2));
                }
            } else {
                oprands.push(s);
            }

        }

        return Integer.parseInt(oprands.pop());
    }

}

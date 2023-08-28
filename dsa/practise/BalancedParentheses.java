package dsa.practise;

import java.util.LinkedList;
import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        balancedParentheses();
    }

    public static int balancedParentheses(){
        String A = "{[()]}";
        Stack<Character> stack = new Stack<>();
        char[] chArr = A.toCharArray();
        for(int i = 0; i < chArr.length; i++){
            char ch = A.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
            } else if (stack.isEmpty()){
                return 0;
            } else {
                if(ch == ']' && stack.peek() == '['){
                    stack.pop();
                } else if(ch == '}' && stack.peek() == '{'){
                    stack.pop();
                } else if (ch == ')' && stack.peek() == '('){
                    stack.pop();
                } else {
                    return 0;
                }
            }

        }
        return stack.isEmpty() ? 1: 0;
    }

}

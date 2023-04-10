package dsa.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        isValid("(())[{}]{()}");
    }

    public static boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stk.add(c);
            }
            if(stk.size() > 0) {
                if (c == ')') {
                    char t = stk.peek();
                    if (t != '(') {
                        return false;
                    }
                    stk.pop();
                } else if (c == '}') {
                    char t = stk.peek();
                    if (t != '{') {
                        return false;
                    }
                    stk.pop();
                } else if (c == ']') {
                    char t = stk.peek();
                    if (t != '[') {
                        return false;
                    }
                    stk.pop();
                }
            } else {
                return false;
            }
        }
        if(stk.size() == 0){
            return true;
        }

        return false;
    }

}

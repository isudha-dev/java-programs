package dsa.contest.july08.tct2reattempt;

import java.util.Stack;

public class RemoveAdjDuplicateInString {

    public static String removeDuplicates(String A) {

        Stack<Character> stk = new Stack<>();

        for(char c: A.toCharArray()){
            if(stk.isEmpty()){
                stk.push(c);
                continue;
            }
            if (!stk.isEmpty() && stk.peek() == c){
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()){
            sb.insert(0,stk.pop());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));
    }


}

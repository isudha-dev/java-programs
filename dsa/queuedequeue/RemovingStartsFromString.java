package dsa.queuedequeue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemovingStartsFromString {

    public static void main(String[] args) {
        System.out.println(removeStar("erase*****"));
    }

    public static String removeStar(String s) {
        // leet**cod*e
        // erase*****
        /*
        stack - l e c o e
        charArr -
         */
        Stack<Character> stk = new Stack<>();

        for(Character c: s.toCharArray()){
            if(c == '*'){
              stk.pop();
            } else {
                stk.push(c);
            }
        }
        int n = stk.size();
        char[] chArr = new char[n];
        for(int i = 0; i < n; i++){
            chArr[n-i-1] = stk.pop();
        }

        return new String(chArr);
    }

}

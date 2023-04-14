package dsa.stack;

import java.util.Stack;

public class ValidateStackSeqLC {

    public static void main(String[] args) {
        int[] pushed = {1,0};
        int[] popped = {1,0};
        System.out.println(validateStackSequences(pushed, popped));
    }


    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length)
            return false;

        Stack<Integer> newPushed = new Stack<>();
        int i = 0, j = 0;

        while (i < pushed.length){
            newPushed.push(pushed[i++]);
            while(!newPushed.isEmpty() && j < popped.length && newPushed.peek() == popped[j]){
                newPushed.pop();
                j++;
            }
        }

        if(!newPushed.isEmpty() || j != popped.length){
            return false;
        }

        return true;
    }

}

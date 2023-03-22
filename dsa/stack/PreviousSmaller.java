package dsa.stack;

import java.util.Stack;

public class PreviousSmaller {

    public static void main(String[] args) {

    }

    public static int[] prevSmaller(int[] A) {

        Stack<Integer> prevSmallStack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!prevSmallStack.isEmpty() && prevSmallStack.peek() > A[i]) {
                prevSmallStack.pop();
            }
            if (prevSmallStack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = prevSmallStack.peek();
            }
            prevSmallStack.push(A[i]);
        }

        return ans;
    }
}
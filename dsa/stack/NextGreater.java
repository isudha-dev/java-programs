package dsa.stack;

import java.util.Stack;

public class NextGreater {
    public int[] nextGreater(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(A[i]);
        }

        return ans;
    }
}

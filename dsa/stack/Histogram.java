package dsa.stack;

import java.util.Stack;

public class Histogram {

    public static void main(String[] args) {
        largestRectangleAreaOptimized(new int[] { 47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9,
                48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54,
                2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49,
                94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27 });
    }

    public int largestRectangleAreaBF(int[] A) {
        int n = A.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            while (l >= 0 && A[l] >= A[i]) {
                l--;
            }
            int r = i + 1;
            while (r < n && A[r] >= A[i]) {
                r++;
            }
            ans = Math.max(ans, A[i] * (r - l - 1));
        }

        return ans;
    }

    public static int largestRectangleAreaOptimized(int[] A) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        }
        int[] prevSmall = prevSmaller(A);
        int[] nextSmall = nextSmaller(A);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int h = A[i];
            int w = nextSmall[i] - prevSmall[i] - 1;
            ans = Math.max(ans, h * w);
            System.out.println("H: " + h + "     W: " + w + "     H*W: " + h * w + "     ans: " + ans);
        }

        return ans;
    }

    public static int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }

    public static int[] nextSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = A.length;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }

}

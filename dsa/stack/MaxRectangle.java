package dsa.stack;

import java.util.Stack;

public class MaxRectangle {

    public static void main(String[] args) {
        int[][] A = new int[][] { { 0, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 } };
        // { 0, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 },
        // { 0, 1, 0 }
        System.out.println(solve(A));

    }

    public static int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] histogram = new int[rows][cols];
        histogram[0] = A[0];

        int ans = largestRectangleAreaBF(histogram[0]);

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 0) {
                    histogram[i][j] = 0;
                } else {
                    histogram[i][j] = histogram[i - 1][j] + A[i][j];
                }
            }
            ans = Math.max(ans, largestRectangleAreaBF(histogram[i]));
        }

        return ans;
    }

    public static int largestRectangleAreaBF(int[] A) {
        int n = A.length;
        int ans = 0;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] == 0)
                continue;
            int l = i - 1;
            while (l >= 0 && A[l] >= A[i]) {
                l--;
            }
            int r = i + 1;
            while (r < n && A[r] >= A[i]) {
                r++;
            }
            ans = Math.max(ans, A[i] * (r - l - 1));
            temp[i] = A[i] * (r - l - 1);
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

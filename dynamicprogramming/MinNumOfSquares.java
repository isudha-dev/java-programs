package dynamicprogramming;

import java.util.Arrays;

public class MinNumOfSquares {

    public static void main(String[] args) {
        MinNumOfSquares min = new MinNumOfSquares();
        min.countMinSquares(12);
    }

    public int countMinSquares(int A) {
        int sqrt = (int) Math.sqrt(A);
        int[] arr = getSquareLessThan(A, sqrt);
        int ans = minSquares(A, arr, arr.length);

        return ans;
    }

    int minSquares(int A, int[] arr, int n) {
        if (A <= 0)
            return 0;
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, 1 + minSquares(A - arr[i], arr, n));
        }
        return (int) ans;
    }

    int[] getSquareLessThan(int A, int sqrt) {
        int[] ans = new int[sqrt];
        Arrays.fill(ans, 0);
        int idx = 0;
        for (int i = 1; i * i <= A; i++) {
            ans[idx] = i;
            idx++;
        }
        return ans;
    }
}

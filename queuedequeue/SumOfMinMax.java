package queuedequeue;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinMax {

    public static int solve(int[] A, int B) {

        int[] max = slidingMaximum(A, B);
        int[] min = slidingMinimum(A, B);

        long ans = 0;
        long mod = 1000000007L;
        for (int i = 0; i < max.length; i++) {
            ans = (ans % mod + max[i] % mod + min[i] % mod) % mod;
        }
        if (ans < 0)
            ans = (ans + mod) % mod;

        return (int) ans;
    }

    public static int[] slidingMaximum(final int[] A, int B) {

        Deque<Integer> deq = new LinkedList<>();
        int[] ans = new int[A.length - B + 1];
        for (int i = 0; i < A.length; i++) {
            while (!deq.isEmpty() && (A[deq.peekLast()] < A[i])) {
                deq.removeLast();
            }
            deq.add(i);
            if (i >= B - 1) {
                while (deq.peek() < (i - B + 1)) {
                    deq.remove();
                }
                ans[i - B + 1] = A[deq.peek()];
            }
        }

        return ans;
    }

    public static int[] slidingMinimum(final int[] A, int B) {

        Deque<Integer> deq = new LinkedList<>();
        int[] ans = new int[A.length - B + 1];
        for (int i = 0; i < A.length; i++) {
            while (!deq.isEmpty() && (A[deq.peekLast()] > A[i])) {
                deq.removeLast();
            }
            deq.add(i);
            if (i >= B - 1) {
                while (deq.peek() < (i - B + 1)) {
                    deq.remove();
                }
                ans[i - B + 1] = A[deq.peek()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] { -24020, -17323, -13684, -25299, -11692, 1032 }, 3));
    }

}

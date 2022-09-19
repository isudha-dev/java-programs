package queuedequeue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public static void main(String[] args) {
        System.out.println(slidingMaximum(new int[] { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876,
                448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277,
                158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 }, 9));
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

}

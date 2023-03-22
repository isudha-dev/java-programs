package dsa.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinLargestElem {

    public static void main(String[] args) {
        MinLargestElem ml = new MinLargestElem();
        System.out.println(ml.solve(new int[] { 4, 8 }, 0));
    }

    public int solve(int[] A, int B) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int[] state = Arrays.copyOf(A, A.length);

        for (int i = 0; i < A.length; i++) {
            minHeap.add(new Pair(2 * A[i], i));
        }

        while (B > 0) {
            Pair top = minHeap.poll();
            state[top.idx] = top.val;
            minHeap.add(new Pair(A[top.idx] + top.val, top.idx));
            B--;
        }

        int maxVal = state[0];
        for (int i = 1; i < state.length; i++)
            maxVal = Math.max(maxVal, state[i]);

        return maxVal;
    }

    class Pair {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

}

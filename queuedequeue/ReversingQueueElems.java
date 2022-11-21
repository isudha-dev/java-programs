package queuedequeue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReversingQueueElems {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        Queue<Integer> q = new LinkedList<>();

        for (int i : A) {
            q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            ans.add(q.poll());
        }
        Collections.reverse(ans);

        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }

    // solution without using in-build reverse
    public static int[] solve(int[] A, int B) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < B; i++)
            dq.add(A[i]);

        for (int i = B - 1; i >= 0; i--) {
            A[i] = dq.remove();
        }

        return A;
    }

    public static void main(String[] args) {
        int[] a = { 43, 35, 25, 5, 34, 5, 8, 7 };
        solve(a, 6);
    }
}

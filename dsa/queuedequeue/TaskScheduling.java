package dsa.queuedequeue;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduling {

    public static void main(String[] args) {

        int[] A = { 1 };
        int[] B = { 1 };

        System.out.println(solve(A, B));

    }

    public static int solve(int[] A, int[] B) {

        Queue<Integer> q = new LinkedList<>();
        for (int i : A) {
            q.add(i);
        }

        int count = 0;
        for (int i : B) {
            int top = q.peek();
            while (top != i) {
                count++;
                q.add(q.remove());
                top = q.peek();
            }
            count++;
            q.remove();

        }

        return count;
    }
}
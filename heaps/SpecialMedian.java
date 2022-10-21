package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SpecialMedian {
    public static void main(String[] args) {
        SpecialMedian sm = new SpecialMedian();
        System.out.println(sm.solve(new ArrayList<>(Arrays.asList(new Integer[] { 2147483647, -2147483648, 0 }))));
    }

    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        int n = A.size();

        maxHeap.add(A.get(0));
        double median = A.get(0);
        for (int i = 1; i < n; i++) {
            if (median == A.get(i))
                return 1;

            if (!maxHeap.isEmpty() && A.get(i) < maxHeap.peek())
                maxHeap.add(A.get(i));
            else
                minHeap.add(A.get(i));

            if (maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.poll());
            else if (maxHeap.size() - minHeap.size() < 0)
                maxHeap.add(minHeap.poll());

            if (maxHeap.size() == minHeap.size())
                median = ((double) (maxHeap.peek() + minHeap.peek()) / 2);
            else
                median = (double) maxHeap.peek();

        }

        maxHeap.removeAll(maxHeap);
        minHeap.removeAll(minHeap);

        maxHeap.add(A.get(n - 1));
        median = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (median == A.get(i))
                return 1;

            if (!maxHeap.isEmpty() && A.get(i) < maxHeap.peek())
                maxHeap.add(A.get(i));
            else
                minHeap.add(A.get(i));

            if (maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.poll());
            else if (maxHeap.size() - minHeap.size() < 0)
                maxHeap.add(minHeap.poll());

            if (maxHeap.size() == minHeap.size())
                median = ((double) (maxHeap.peek() + minHeap.peek()) / 2);
            else
                median = (double) maxHeap.peek();

        }

        return 0;
    }

    public double findMedian(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        for (int i : A) {
            if (maxHeap.isEmpty() || i < maxHeap.peek())
                maxHeap.add(i);
            else
                minHeap.add(i);

            if (maxHeap.size() - minHeap.size() > 1) {
                int top = maxHeap.poll();
                minHeap.add(top);
            } else if (maxHeap.size() - minHeap.size() < 0) {
                int top = minHeap.poll();
                maxHeap.add(top);
            }
        }

        if (maxHeap.size() == minHeap.size())
            return ((double) (maxHeap.peek() + minHeap.peek()) / 2);
        else
            return (double) maxHeap.peek();
    }
}

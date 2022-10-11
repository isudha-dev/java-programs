package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();
        rm.solve(new int[] { 5, 17, 100, 11 });
    }

    class MyComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }

    public int[] solve(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());

        int[] ans = new int[A.length];
        int idx = 0;

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
            // in assignment question median for even is given as N/2-1
            // so we can simply return maxHeap.peek() for both even and odd
            if (maxHeap.size() == minHeap.size())
                ans[idx] = ((maxHeap.peek() + minHeap.peek()) / 2);
            else
                ans[idx] = maxHeap.peek();
            idx++;

        }

        return ans;
    }

}

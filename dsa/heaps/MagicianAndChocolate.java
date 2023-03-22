package dsa.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolate {

    public static void main(String[] args) {
        MagicianAndChocolate mc = new MagicianAndChocolate();
        System.out.println(mc.nchoc(10, new int[] { 2147483647, 2000000014, 2147483647 }));
    }

    class MyComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }

    public int nchoc(int A, int[] B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());
        for (int i : B)
            maxHeap.add(i);

        long sum = 0;
        long mod = 1000000007L;
        for (int i = 0; i < A; i++) {
            int max = maxHeap.poll();
            sum = (sum + (long) max) % mod;
            maxHeap.add(max / 2);
        }

        return (int) (sum % mod);
    }

}

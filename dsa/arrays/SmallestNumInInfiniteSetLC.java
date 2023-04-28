package dsa.arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/smallest-number-in-infinite-set/
public class SmallestNumInInfiniteSetLC {

    public static void main(String[] args) {
        SmallestInfiniteSet s = new SmallestInfiniteSet();
        s.addBack(2);
        s.popSmallest();
        s.popSmallest();
        s.popSmallest();
        s.addBack(1);
        s.popSmallest();
        s.popSmallest();
        s.popSmallest();
    }

    static class SmallestInfiniteSet {

        PriorityQueue<Integer> minHeap;
        Set<Integer> set;

        public SmallestInfiniteSet() {
            minHeap = new PriorityQueue<>();
            set = new HashSet<>();

            for(int i = 1; i <= 1000; i++){
                minHeap.add(i);
                set.add(i);
            }
        }

        public int popSmallest() {
            int i = minHeap.poll();
            set.remove(i);
            return i;
        }

        public void addBack(int num) {
            if(!set.contains(num)){
                set.add(num);
                minHeap.add(num);
            }
        }
    }

}

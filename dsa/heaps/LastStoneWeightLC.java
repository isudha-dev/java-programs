package dsa.heaps;

import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeightLC {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[] {2,2}));
    }
    public static int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for(int i: stones){
            maxHeap.add(i);
        }
        while(maxHeap.size() > 1){
            int one = maxHeap.poll();
            int two = maxHeap.poll();
            if(one != two){
                int diff = one - two;
                maxHeap.add(diff);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}

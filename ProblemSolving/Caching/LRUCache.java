package ProblemSolving.Caching;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LRUCache {

    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> mapForValue;
    HashMap<Integer, Integer> mapForTime;
    int size;
    int timer;

    public LRUCache(int capacity) {
        pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        mapForValue = new HashMap<>();
        mapForTime = new HashMap<>();
        size = capacity;
        timer = 0;
    }

    public int get(int key) {
        if(mapForValue.containsKey(key)){
            timer++;
            mapForTime.put(key, timer);
            pq.add(new int[] {key, timer});
            return mapForValue.get(key);
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        timer++;
        pq.add(new int[] {key, timer});
        if(mapForTime.containsKey(key) || mapForTime.size() < size){
            mapForValue.put(key, value);
            mapForTime.put(key, timer);
        } else {
            while (true){
                int[] topOfQ = pq.peek();
                if(topOfQ[1] != mapForTime.get(topOfQ[0])){
                    pq.poll();
                } else {
                    int[] top = pq.poll();
                    mapForValue.remove(top[0]);
                    mapForTime.remove(top[0]);
                    mapForTime.put(key, timer);
                    mapForValue.put(key, value);
                    break;
                }
            }

        }

    }

    public static void main(String[] args) {
        // 7 2 G 2 S 2 6 G 1 S 1 5 S 1 2 G 1 G 2
        LRUCache lc = new LRUCache(2);
        System.out.println(lc.get(2));
        lc.set(2,6);
        System.out.println(lc.get(1));
        lc.set(1, 5);
        lc.set(1,2);
        System.out.println(lc.get(1));
        System.out.println(lc.get(2));
        // e -1 -1 2 6 a -1 -1 2 -1
    }

}

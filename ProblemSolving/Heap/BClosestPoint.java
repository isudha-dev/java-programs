package ProblemSolving.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BClosestPoint {

    public static void main(String[] args) {
        // [[26,41],[40,47],[47,7],[50,34],[18,28]]
        // [[48,18],[46,34],[47,30],[19,9],[1,39],[95,77],[95,106],[78,75],[92,108],[89,83],[80,76]]
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(48,18)));
        A.add(new ArrayList<>(List.of(46,34)));
        A.add(new ArrayList<>(List.of(47,30)));
        A.add(new ArrayList<>(List.of(19,9)));
        A.add(new ArrayList<>(List.of(1,39)));
        A.add(new ArrayList<>(List.of(95,77)));
        A.add(new ArrayList<>(List.of(95,106)));
        A.add(new ArrayList<>(List.of(78,75)));
        A.add(new ArrayList<>(List.of(92,108)));
        A.add(new ArrayList<>(List.of(89,83)));
        A.add(new ArrayList<>(List.of(80,76)));

        ArrayList<ArrayList<Integer>> ans = solve(A, 5);
        System.out.println(ans);

    }
    static class Pair {
        int val;
        int index;

        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.val - a.val);
        /*
            a = 5, b = 7, b-a = 2 which is positive, b comes first
            a = 5, b = 3, b-a = -2 which is -ve, a comes first
            so if a is bigger, a will come first else b will come first.
            max heap
         */

        for (int i = 0; i < A.size() ; i++) {
            ArrayList<Integer> arr = A.get(i);
            int s1 = arr.get(0)*arr.get(0);
            int s2 = arr.get(1)*arr.get(1);
            Pair p = new Pair(s1+s2, i);
            queue.add(p);
        }
        while (queue.size() > B) {
            queue.poll();
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int idx = 0;
        while (idx < B){
            ans.add(A.get(queue.poll().index));
            idx++;
        }

        return ans;

    }
}

package dsa.heaps;

import java.util.PriorityQueue;

public class MishaAndCandies {

    public static void main(String[] args) {
        MishaAndCandies mac = new MishaAndCandies();
        mac.solve(new int[] { 705 }, 895);
    }

    public int solve(int[] A, int B) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : A) {
            pq.add(i);
        }

        int totalCandiesEaten = 0;
        while (!pq.isEmpty() && pq.peek() <= B) {
            int top = pq.poll();
            int candiesEaten = top / 2;
            int candiesTransfered = top - candiesEaten;
            totalCandiesEaten += candiesEaten;
            if (pq.isEmpty()) {
                break;
            }
            top = pq.poll();
            pq.add(top + candiesTransfered);
        }

        return totalCandiesEaten;
    }

}

package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BthSmallestPrimeFact {

    public static void main(String[] args) {
        BthSmallestPrimeFact bp = new BthSmallestPrimeFact();
        bp.solve(new int[] { 1, 2, 3, 5 }, 3);
    }

    class Triplet {
        Float fraction;
        int x;
        int y;

        Triplet(Float fraction, int x, int y) {
            this.fraction = fraction;
            this.x = x;
            this.y = y;
        }
    }

    public int[] solve(int[] A, int B) {

        PriorityQueue<Triplet> pq = new PriorityQueue<>(Comparator.comparing(a -> a.fraction));

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                float fraction = (float) A[i] / A[j];
                pq.add(new Triplet(fraction, A[i], A[j]));
            }
        }

        while (B > 1 && !pq.isEmpty()) {
            pq.poll();
            B--;
        }

        Triplet ans = pq.poll();

        return new int[] { ans.x, ans.y };
    }

}

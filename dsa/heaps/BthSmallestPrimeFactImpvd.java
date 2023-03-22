package dsa.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BthSmallestPrimeFactImpvd {

    public int[] solve(int[] A, int B) {
        int K = B;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(new CustomComp());
        Map<Integer, Integer> nxt = new HashMap<Integer, Integer>();
        for (int i = A.length - 1; i > 0; i--) {
            if (nxt.containsKey(A[i]) == true)
                nxt.replace(A[i], A[i - 1]);
            else
                nxt.put(A[i], A[i - 1]);
        }

        double last = (double) A[A.length - 1];
        double d;
        if (nxt.containsKey(1) == true)
            nxt.replace(1, 0);
        else
            nxt.put(1, 0);

        for (int i = 0; i < A.length; i++) {
            d = (double) A[i] / last;
            q.offer(new Pair(d, A[i], (int) last));
        }

        while (q.size() > 0 && K > 0) {
            K--;
            if (K == 0)
                break;
            Pair p = q.poll();
            if (nxt.containsKey(p.tt) == true && nxt.get(p.tt) != 0) {
                p.tt = nxt.get(p.tt);
                d = (double) p.ss / (double) p.tt;
                q.offer(new Pair(d, p.ss, p.tt));
            }
        }
        int[] ret = new int[2];
        ret[0] = q.peek().ss;
        ret[1] = q.peek().tt;

        return ret;
    }
}

// class and comparator for pairs
class Pair {
    double ff;
    int ss;
    int tt;

    public Pair(double c, int d, int e) {
        this.ff = c;
        this.ss = d;
        this.tt = e;
    }
}

class CustomComp implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        if (a.ff > b.ff)
            return 1;
        return -1;
    }
}

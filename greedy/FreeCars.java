package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FreeCars {
    public int solve(int[] A, int[] B) {
        Deal[] deals = new Deal[A.length];
        int mod = 1000000007;

        for (int i = 0; i < A.length; i++) {
            deals[i] = new Deal(A[i], B[i]);
        }

        // Sort based on deadline
        Arrays.sort(deals, (a, b) -> {
            if (a.deadline < b.deadline) {
                return -1;
            } else {
                return 1;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long ans = 0;
        int timer = 0;
        for (Deal deal : deals) {
            if (timer < deal.deadline) {
                timer++;
                minHeap.add(deal.profit);
                ans += deal.profit;
                ans %= mod;
            } else {
                if (deal.profit > minHeap.peek()) {
                    int min = minHeap.poll();
                    ans -= min;
                    ans %= mod;
                    minHeap.add(deal.profit);
                    ans += deal.profit;
                    ans %= mod;
                }
            }
        }
        return (int) (ans % mod);
    }

    static class Deal {
        int deadline;
        int profit;

        Deal(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

}

package hashing;

import java.util.HashMap;

public class ShaggyAndDistances {

    public static void main(String[] args) {
        ShaggyAndDistances sd = new ShaggyAndDistances();
        sd.solve(new int[] { 7, 1, 3, 4, 1, 7 });
    }

    public int solve(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (!hm.containsKey(A[i])) {
                hm.put(A[i], i);
            } else {
                ans = Math.min(ans, i - hm.get(A[i]));
                hm.put(A[i], i);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}

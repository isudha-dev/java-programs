package hashing;

import java.util.HashMap;

public class CountRightAngleTriangle {

    // solution with unordered set - TC: O(N^2)
    public static int solve1(int[] A, int[] B) {
        int mod = 1000000007;
        HashMap<Integer, Integer> xSet = new HashMap<>();
        HashMap<Integer, Integer> ySet = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            xSet.put(A[i], xSet.getOrDefault(A[i], 0) + 1);
            ySet.put(B[i], ySet.getOrDefault(B[i], 0) + 1);
        }

        long count = 0;
        for (int i = 0; i < A.length; i++) {
            count = (count + ((xSet.get(A[i]) - 1) % mod * (ySet.get(B[i]) - 1) % mod) % mod) % mod;
        }

        return (int) count;
    }

}

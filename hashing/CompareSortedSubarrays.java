package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CompareSortedSubarrays {

    public static void main(String[] args) {
        solve1(new int[] { 100000, 100000, 100000, 100000, 100000 },
                new int[][] { { 0, 3, 1, 4 }, { 0, 1, 2, 3 }, { 4, 4, 1, 1, }, { 1, 3, 0, 0 }, { 2, 4, 1, 1 } });
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

        HashMap<Integer, Long> hm = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            if (!hm.containsKey(A.get(i))) {
                Long l = getRandomNumber();
                hm.put(A.get(i), l);
            }
        }

        long[] prefixSum = new long[A.size()];
        prefixSum[0] = hm.get(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + hm.get(A.get(i));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < B.size(); i++) {
            long l1r1 = prefixSum[B.get(i).get(1)] - prefixSum[B.get(i).get(0) - 1];
            long l2r2 = prefixSum[B.get(i).get(3)] - prefixSum[B.get(i).get(2) - 1];
            if (l1r1 == l2r2) {
                ans.add(1);
            } else {
                ans.add(0);
            }

        }

        return ans;
    }

    public static int[] solve1(int[] A, int[][] B) {

        HashMap<Integer, Long> hm = new HashMap<>();
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(A[i])) {
                Long l = getRandomNumber();
                hm.put(A[i], l);
            }
        }

        long[] prefixSum = new long[n];
        prefixSum[0] = hm.get(A[0]);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + hm.get(A[i]);
        }

        int[] ans = new int[B.length];
        int idx = 0;
        for (int i = 0; i < B.length; i++) {
            long l1r1 = getPrefixSumRange(prefixSum, B[i][0], B[i][1]);
            long l2r2 = getPrefixSumRange(prefixSum, B[i][2], B[i][3]);
            if (l1r1 == l2r2) {
                ans[idx] = 1;
            } else {
                ans[idx] = 0;
            }
            idx++;
        }

        return ans;
    }

    public static long getRandomNumber() {
        long range = 1000000000007L;
        long ans = (long) (Math.random() * range + 1);
        return ans;
    }

    public static long getPrefixSumRange(long[] prefixSum, int start, int end) {
        if (start == 0) {
            return prefixSum[end];
        } else {
            return prefixSum[end] - prefixSum[start - 1];
        }
    }

}
import java.util.ArrayList;

public class ChrismasTree {
    // https://www.scaler.com/academy/mentee-dashboard/class/25587/assignment/problems/1083?navref=cl_tt_nv
    public static void main(String[] args) {
        int[] A = { 1, 6, 4, 2, 6, 9 };
        int[] B = { 2, 5, 7, 3, 2, 7 };
        System.out.println(solve(A, B));

    }

    static int solve(int[] A, int[] B) {
        int cost = Integer.MAX_VALUE;
        int n = A.length;

        for (int q = 1; q < n - 1; q++) {

            int left_smaller = 0;
            ArrayList<Integer> leftIdx = new ArrayList<>();
            for (int p = q - 1; p >= 0; p--) {
                if (A[p] < A[q]) {
                    left_smaller++;
                    leftIdx.add(p);
                }
            }

            int right_larger = 0;
            ArrayList<Integer> rightIdx = new ArrayList<>();
            for (int r = q + 1; r < n; r++) {
                if (A[r] > A[q]) {
                    right_larger++;
                    rightIdx.add(r);
                }
            }
            if (left_smaller != 0 && right_larger != 0) {
                for (int p : leftIdx) {
                    int localCost = 0;
                    for (int r : rightIdx) {
                        localCost = B[p] + B[q] + B[r];
                        cost = Math.min(cost, localCost);
                    }
                }
            }
        }
        if (cost == Integer.MAX_VALUE)
            return -1;
        else
            return cost;
    }

}

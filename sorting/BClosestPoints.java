package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class BClosestPoints {

    public int[][] solve(int[][] A, int B) {
        if (A.length == 0 || A.length == 1) {
            return A;
        }

        Arrays.sort(A, new Comparator<int[]>() {

            @Override
            public int compare(int[] p, int[] q) {
                int d1 = p[0] * p[0] + p[1] * p[1];
                int d2 = q[0] * q[0] + q[1] * q[1];
                if (d1 > d2) {
                    return 1;
                }
                return -1;
            }
        });

        int ans[][] = new int[B][2];
        for (int i = 0; i < B; i++) {
            ans[i][0] = A[i][0];
            ans[i][1] = A[i][1];
        }

        return ans;
    }

}

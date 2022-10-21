package greedy;

import java.util.Arrays;

public class MiceToHoles {

    public static void main(String[] args) {
        mice(new int[] { -2 }, new int[] { -6 });
    }

    public static int mice(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(A[i] - B[i]);
            ans = Math.max(ans, diff);
        }

        return ans;
    }

}

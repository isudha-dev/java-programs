import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/25587/homework/problems/8515?navref=cl_tt_nv

public class MaxPositivity {

    public static void main(String[] args) {

        int[] ans = solve(new int[] { -5173778, 4330572 });
        System.out.println(ans);
    }

    static int[] solve(int[] A) {

        int n = A.length;
        int startIdx = -1;
        int endIdx = -1;
        int maxCount = Integer.MIN_VALUE;

        int currCount = 0;
        int currStartIdx = -1;
        for (int i = 0; i < n; i++) {

            if (A[i] > 0 && currStartIdx == -1) {
                currStartIdx = i;
                currCount++;
            } else if (A[i] > 0 && currStartIdx != -1) {
                currCount++;
            }
            if (i == n - 1 || (A[i] < 0 && currStartIdx != -1)) {
                if (currCount > maxCount) {
                    maxCount = currCount;
                    startIdx = currStartIdx;
                    endIdx = (i == n - 1) ? n : i;
                }
                currStartIdx = -1;
                currCount = 0;
            }
        }
        return Arrays.copyOfRange(A, startIdx, endIdx);
    }

}

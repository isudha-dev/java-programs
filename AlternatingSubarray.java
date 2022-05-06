import java.util.ArrayList;

public class AlternatingSubarray {

    // https://www.scaler.com/academy/mentee-dashboard/class/25551/homework/problems/16123?navref=cl_tt_nv

    public static void main(String[] args) {
        ArrayList<Integer> ans = solve(
                new int[] { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1 }, 1);
        System.out.println();
    }

    static ArrayList<Integer> solve(int[] A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.length;
        int reqLen = 2 * B + 1;

        for (int i = 0, start = 0; i < n - 2; i++) {
            int curr = A[i];
            int next = A[i + 1];
            int currLen = i - start + 2;

            if (curr == next) {
                start = i + 1;
            } else if ((curr != next) && currLen >= reqLen) {
                ans.add(start + B);
                start++;
            }

        }

        return ans;

    }

    static int solveCount(int[] A, int B) {
        if (B == 0) {
            return A.length;
        }

        int n = A.length;
        int subarrayLen = 0;
        int count = 0;
        int len = 2 * B + 1;

        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1] && subarrayLen != 0 && i != n - 1) {
                count += subarrayLen + 1 - len + 1;
                subarrayLen = 0;
            } else if (A[i] != A[i - 1]) {
                subarrayLen++;
            }
            if (i == n - 1) {
                count += subarrayLen + 1 - len + 1;
            }
        }

        return count;
    }

}

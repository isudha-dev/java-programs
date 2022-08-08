package binarysearch;

import java.util.Arrays;

public class AggresiveCows {

    public static void main(String[] args) {
        AggresiveCows ac = new AggresiveCows();
        ac.solve(new int[] { 5, 17, 100, 11 }, 2);
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int low = 1, high = A[A.length - 1] - A[0];

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] A, int B, int mid) {
        int recent_placed = A[0];
        int cows_placed = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] - recent_placed >= mid) {
                cows_placed++;
                recent_placed = A[i];
            }
        }
        if (cows_placed >= B) {
            return true;
        }
        return false;
    }

}

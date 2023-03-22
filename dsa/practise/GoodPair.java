package dsa.practise;

import java.util.Arrays;

public class GoodPair {

    public static void main(String[] args) {
        solve(new int[] { 1, 2, 4 }, 4);
    }

    public static int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            int ans = binarySearch(A, B - A[i], i + 1);
            if (ans != -1)
                return 1;
        }

        return 0;
    }

    public static int binarySearch(int[] A, int B, int start) {

        int end = A.length - 1;
        // if (B == A[start] || B == A[end]) {
        // return 1;
        // }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] == B) {
                return 1;
            } else if (B > A[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;

    }
}
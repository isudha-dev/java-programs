package dsa.sorting;

public class MaxUnsortedSubarray {

    public static void main(String[] args) {
        MaxUnsortedSubarray mus = new MaxUnsortedSubarray();
        mus.subUnsort(new int[] { 4, 15, 4, 4, 15, 18, 20 });

    }

    public int[] subUnsort(int[] A) {
        int n = A.length;

        int i = 0, j = n - 1;

        while (i < n - 1 && A[i] <= A[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return new int[] { -1 };
        }

        while (j > 0 && A[j] >= A[j - 1]) {
            j--;
        }

        int max = A[i], min = A[i];

        for (int k = i; k <= j; k++) {
            max = Math.max(max, A[k]);
            min = Math.min(min, A[k]);
        }

        int lo = 0, hi = n - 1;

        while (lo <= i && A[lo] <= min) {
            lo++;
        }
        while (hi >= j && A[hi] >= max) {
            hi--;
        }

        return new int[] { lo, hi };

    }
}
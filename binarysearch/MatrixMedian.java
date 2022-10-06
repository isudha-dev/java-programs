package binarysearch;

import java.util.List;

public class MatrixMedian {

    public int findMedian1(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            low = Math.min(low, A[i][0]);
            high = Math.max(high, A[i][cols - 1]);
        }
        int median = -1;
        int desiredCount = (rows * cols) / 2 + 1;
        while (low <= high) {
            int midValue = low + (high - low) / 2;
            int count = 0;
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                count += countNumOfElemsLessOrEqualToMid(A, rowIndex, 0,
                        cols - 1, midValue);
            }
            if (count >= desiredCount) {
                median = midValue;
                high = midValue - 1;
            } else
                low = midValue + 1;
        }
        return median;
    }

    private int countNumOfElemsLessOrEqualToMid(int[][] A, int rowIndex, int low,
            int high, int mid) {
        while (low <= high) {
            int midIndex = (low + high) / 2;
            if (A[rowIndex][midIndex] <= mid) {
                low = midIndex + 1;
            } else
                high = midIndex - 1;
        }
        return low;
    }

    public int lowerBound(List<Integer> a, int target) {

        if (target > a.get(a.size() - 1)) {
            return a.size();
        }
        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public double findMedian2SortedArrays(final List<Integer> a, final List<Integer> b, int k) {

        int low = Math.min(a.get(0), b.get(0));
        int high = Math.max(a.get(a.size() - 1), b.get(b.size() - 1));
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            count += lowerBound(a, mid);
            count += lowerBound(b, mid);

            if (count > k) {
                high = mid - 1;
            } else if (count <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}

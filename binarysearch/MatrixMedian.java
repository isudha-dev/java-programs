package binarysearch;

public class MatrixMedian {

    public int findMedian(int[][] A) {
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

    private int countNumOfElemsLessOrEqualToMid(int[][] A, int rowIndex, int low, int high, int mid) {
        while (low <= high) {
            int midIndex = (low + high) / 2;
            if (A[rowIndex][midIndex] <= mid) {
                low = midIndex + 1;
            } else
                high = midIndex - 1;
        }
        return low;
    }

}

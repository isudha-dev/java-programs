package dsa.binarysearch;

public class SearchInBitonicArray {

    public static void main(String[] args) {
        SearchInBitonicArray si = new SearchInBitonicArray();
        System.out.println(
                si.solve(new int[] { 7, 8, 9, 10, 20, 25, 26, 27, 16, 15, 14, 13, 12, 11, 6, 5, 4, 3, 2, 1 }, 12));
    }

    public int solve(int[] A, int B) {

        if (A.length == 1 && A[0] == B) {
            return 0;
        }

        int bitonicPoint = findBitonicPoint(A, 0, A.length - 1);

        if (bitonicPoint == 0) {
            return binarySearchIncreasing(A, 0, A.length - 1, B);
        }

        if (B > A[bitonicPoint]) {
            return -1;
        } else if (B == A[bitonicPoint]) {
            return bitonicPoint;
        } else {
            int left = -1, right = -1;
            left = binarySearchIncreasing(A, 0, bitonicPoint, B);
            if (left == -1) {
                right = binarySearchDecreasing(A, bitonicPoint + 1, A.length - 1, B);
                return right;
            } else {
                return left;
            }
        }
    }

    // finding bitonic point
    public int findBitonicPoint(int[] arr, int low, int high) {
        int mid;
        mid = (low + high) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return findBitonicPoint(arr, mid + 1, high);
        }
        return findBitonicPoint(arr, low, mid);
    }

    public int binarySearchIncreasing(int[] A, int low, int high, int target) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > target) {
                // go left
                high = mid - 1;
            } else {
                // go right
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchDecreasing(int[] A, int low, int high, int target) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                // go left
                high = mid - 1;
            } else {
                // go right
                low = mid + 1;
            }
        }
        return -1;
    }

}

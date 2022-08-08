package binarysearch;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        RotatedSortedArraySearch rs = new RotatedSortedArraySearch();
        System.out.println(rs.search(new int[] { 1, 7, 67, 133, 178 }, 1));
    }

    public int search(final int[] A, int B) {
        if (A.length == 1 && A[0] == B) {
            return 0;
        }

        int k = rotationFactor(A);
        if (k == 0) {
            return binarySearch(A, 0, A.length - 1, B);
        }
        if (B >= A[0]) {
            return binarySearch(A, 0, k - 1, B);
        } else {
            return binarySearch(A, k, A.length - 1, B);
        }

    }

    public int rotationFactor(final int[] A) {

        int low = 0, high = A.length - 1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] < A[0]) {
                // go left
                ans = mid;
                high = mid - 1;
            } else {
                // go right
                low = mid + 1;
            }

        }
        return ans;
    }

    public int binarySearch(int[] A, int low, int high, int target) {

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

}

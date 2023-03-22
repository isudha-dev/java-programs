package dsa.binarysearch;

public class LowerBound {

    public static void main(String[] args) {
        LowerBound lb = new LowerBound();
        System.out.println(lb.lowerBound(new int[] { 1, 3, 5, 11, 11, 13, 13, 13, 15 }, 11));
    }

    public int lowerBound(int[] A, int B) {

        if (B > A[A.length - 1]) {
            return A.length - 1;
        }
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

}

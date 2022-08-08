package binarysearch;

public class SortedInsertPosition {

    public static void main(String[] args) {
        SortedInsertPosition sip = new SortedInsertPosition();
        System.out.println(sip.searchInsert(new int[] { 2, 3, 5, 6, 10 }, 10));
    }

    public int searchInsert(int[] A, int B) {

        int low = 0, high = A.length - 1;

        int ans = A.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] >= B) {
                // go left
                high = mid - 1;
                ans = mid;
            } else {
                // go right
                low = mid + 1;
            }
        }
        return ans;
    }

}

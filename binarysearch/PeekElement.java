package binarysearch;

public class PeekElement {

    public static void main(String[] args) {
        PeekElement pe = new PeekElement();
        System.out.println(pe.solve(new int[] { 3, 8, 2, 8, 9, 10, 9, 7 }));
    }

    public int solve(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        if (A[0] >= A[1]) {
            return A[0];
        }
        if (A[A.length - 1] >= A[A.length - 2]) {
            return A[A.length - 1];
        }
        int low = 0, high = A.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] >= A[mid + 1] && A[mid] >= A[mid - 1]) {
                return A[mid];
            } else if (A[mid + 1] > A[mid]) {
                low = mid + 1;
            } else if (A[mid - 1] > A[mid]) {
                high = mid - 1;
            }
        }

        return ans;
    }

}

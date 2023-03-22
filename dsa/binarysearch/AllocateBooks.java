package dsa.binarysearch;

public class AllocateBooks {

    public static void main(String[] args) {
        AllocateBooks ab = new AllocateBooks();
        System.out.println(ab.books(new int[] { 12, 34, 67, 90 }, 12));
    }

    public int books(int[] A, int B) {
        if (B > A.length)
            return -1;

        int sum = 0, max = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, A[i]);
        }

        int low = max, high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(A, B, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;

    }

    public boolean check(int[] A, int B, int mid) {
        int students = 1;
        int pages = 0;
        for (int i = 0; i < A.length; i++) {
            pages += A[i];
            if (pages > mid) {
                students++;
                pages = A[i];
            }
        }
        if (students > B)
            return false;
        return true;
    }

}

package dsa.sorting;

public class ReversePair {

    public static void main(String[] args) {

        System.out.println(solve(new int[] { 2000000000, 2000000000, -2000000000 }));

        // 14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380,
        // 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044,
        // 78056, 45190, 94365, 58869, 20611
    }

    // 51 vs 36
    static int solve(int[] A) {

        return revPairs(A, 0, A.length - 1);

    }

    static int revPairs(int[] A, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) / 2;

        int left = revPairs(A, low, mid);
        int right = revPairs(A, mid + 1, high);

        int i = low;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= high) {
            long temp = (long) 2 * A[j];
            if (A[i] > temp) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        mergeSortedArray1(A, low, mid, high);
        return count + left + right;
    }

    static void mergeSortedArray1(int[] A, int low, int mid, int high) {
        int p1 = low;
        int p2 = mid + 1;
        int i = 0;
        int[] ans = new int[high - low + 1];

        while (p1 <= mid && p2 <= high) {
            if (A[p1] < A[p2]) {
                ans[i] = A[p1];
                p1++;
            } else {
                ans[i] = A[p2];
                p2++;
            }
            i++;
        }
        while (p1 <= mid) {
            ans[i] = A[p1];
            p1++;
            i++;
        }
        while (p2 <= high) {
            ans[i] = A[p2];
            p2++;
            i++;
        }

        i = 0;
        for (int j = low; j <= high; j++) {
            A[j] = ans[i];
            i++;
        }
    }
}

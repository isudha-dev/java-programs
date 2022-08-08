package sorting;

public class InversionCount {

    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        return inversionCount(A, 0, A.length - 1);
    }

    private int inversionCount(int[] A, int start, int end) {
        int MOD = 1000000007;
        if (start == end)
            return 0;

        int mid = (start + end) / 2;
        int l = inversionCount(A, start, mid) % MOD;
        int r = inversionCount(A, mid + 1, end) % MOD;
        int m = merge(A, start, mid, end) % MOD;
        return (l + r + m) % MOD;
    }

    private int merge(int[] A, int start, int mid, int end) {
        int count = 0;
        int p1 = start;
        int p2 = mid + 1;
        int p3 = 0;
        int MOD = 1000000007;
        int[] c = new int[end - start + 1];
        while (p1 <= mid && p2 <= end) {
            if (A[p1] <= A[p2]) {
                c[p3] = A[p1];
                p1++;
                p3++;
            } else {
                c[p3] = A[p2];
                p2++;
                p3++;
                count += (mid - p1 + 1) % MOD;
            }
        }
        while (p1 <= mid) {
            c[p3] = A[p1];
            p1++;
            p3++;
        }

        while (p2 <= end) {
            c[p3] = A[p2];
            p2++;
            p3++;
        }

        p3 = 0;
        for (int i = start; i <= end; i++) {
            A[i] = c[p3];
            p3++;
        }
        return count % MOD;

    }
}

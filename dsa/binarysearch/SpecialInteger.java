package dsa.binarysearch;

public class SpecialInteger {

    public static void main(String[] args) {

        SpecialInteger si = new SpecialInteger();
        System.out.println(si.solve(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, 20));

    }

    public int solve(int[] A, int B) {
        long low = 0, high = A.length;
        long ans = 0;

        while (low <= high) {
            long mid = (long) (low + high) / 2;
            if (subArrayCheck(A, mid, B)) {
                // go right
                ans = mid;
                low = mid + 1;
            } else {
                // go left
                high = mid - 1;
            }

        }

        return (int) ans;
    }

    public boolean subArrayCheck(int[] A, long l, int B) {
        // returns true if all the dsa.subarray of length l has sum less than B
        int n = A.length;
        int p1 = 0, p2 = (int) l - 1;
        long sum = 0;
        for (int i = (int) p1; i <= p2; i++) {
            sum += A[i];
        }
        if (sum > B) {
            return false;
        }
        p1++;
        p2++;

        while (p2 < n) {
            sum -= (int) A[p1 - 1];
            sum += (int) A[p2];
            if (sum > B) {
                return false;
            }
            p1++;
            p2++;
        }

        return true;
    }

}

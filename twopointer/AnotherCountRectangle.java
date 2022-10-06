package twopointer;

public class AnotherCountRectangle {

    public static int solve(int[] A, int B) {
        int mod = 1000000007;
        int p1 = 0, p2 = A.length - 1;
        long count = 0;
        while (p1 <= p2) {
            long area = (long) (A[p1] * A[p2]);
            if (area < B) {
                long tempCount = 2 * (p2 - p1) + 1;
                count = (count + tempCount) % mod;
                p1++;
            } else
                p2--;
        }

        return (int) count;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] { 1, 2, 3, 4, 5 }, 5));
    }
}

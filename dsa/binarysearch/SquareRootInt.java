package dsa.binarysearch;

public class SquareRootInt {

    public static void main(String[] args) {
        SquareRootInt sq = new SquareRootInt();
        System.out.println(sq.sqrt(2147483647));
    }

    public int sqrt(int A) {

        int low = 0, high = A;
        int mid = (low + high) / 2;
        int ans = 0;

        while (low <= high) {
            long mul = (long) mid * mid;

            if (mul > A) {
                // go left
                high = mid - 1;
            } else {
                // go right
                low = mid + 1;
            }
            if (mul <= A) {
                ans = mid;
            }

            mid = (low + high) / 2;
        }

        return ans;
    }

}

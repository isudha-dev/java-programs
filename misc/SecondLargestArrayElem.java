public class SecondLargestArrayElem {
    public static void main(String[] args) {
        int[] A = { 3, 3, 3, 3 };

        System.out.println(solve(A));

    }

    static int solve(int[] A) {
        int max1 = 0;
        int max2 = 0;
        if (A.length == 0 || A.length == 1) {
            return -1;
        } else {
            max1 = A[0];
            for (int i = 1; i < A.length; i++) {
                if (A[i] > max1) {
                    max1 = A[i];
                }
            }
            max2 = max1;
            for (int i = 1; i < A.length; i++) {
                if (A[i] > max2 && A[i] < max1) {
                    max2 = A[i];
                }
            }
        }
        return max2;
    }

}

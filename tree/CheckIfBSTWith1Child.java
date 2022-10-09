package tree;

public class CheckIfBSTWith1Child {

    public static String solve(int[] A) {
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;

        if (A.length == 1) {
            return "YES";
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] < l || A[i] > r) {
                return "NO";
            } else {
                if (A[i] < A[i - 1]) {
                    r = A[i - 1];
                } else if (A[i] > A[i - 1])
                    l = A[i - 1];
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] { 2, 10, 6, 9, 7, 8 }));
    }

}

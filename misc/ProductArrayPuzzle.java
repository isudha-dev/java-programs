public class ProductArrayPuzzle {
    // https://www.scaler.com/academy/mentee-dashboard/class/25549/homework/problems/4103?navref=cl_tt_nv

    public static void main(String[] args) {

        System.out.println(solve(new int[] { 1, 2, 3, 4, 5 }));
    }

    static int[] solve(int[] A) {
        int prod = A[0];
        int[] arr = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            prod *= A[i];
        }

        for (int i = 0; i < A.length; i++) {
            arr[i] = prod / A[i];
        }

        return arr;
    }
}

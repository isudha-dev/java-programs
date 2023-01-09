public class GoodPair {

    public static void main(String[] args) {

        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int B = 18;
        System.out.println(solve(A, B));

    }

    static int solve(int[] A, int B) {

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == B) {
                    return 1;
                }
            }
        }

        return 0;
    }

}

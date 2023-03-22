package primer;

public class MinPicks {

    // Return maximum among all even numbers of A - minimum among all odd numbers in
    // A
    public static void main(String[] args) {

        System.out.println(solve(new int[] { -6, -9 }));

    }

    static int solve(int[] A) {

        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0 && A[i] > maxEven) {
                maxEven = A[i];
            }
            if (A[i] % 2 != 0 && A[i] < minOdd) {
                minOdd = A[i];
            }

        }

        return maxEven - minOdd;
    }

}

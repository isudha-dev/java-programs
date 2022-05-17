package array_rotation;

public class ArrayMultipleRotation {
    // The first argument given is the integer array A.
    // The second argument given is the integer array B.

    public static void main(String[] args) {

        solve(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3 });

    }

    static int[][] solve(int[] A, int[] B) {
        int[][] result = new int[B.length][];
        int[] partialResult = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int[] tempA = new int[A.length];
            for (int j = 0; j < A.length; j++) {
                tempA[j] = A[j];
            }
            B[i] = B[i] % tempA.length;
            partialResult = rotateArrayLeft(tempA, B[i]);
            result[i] = partialResult;
        }

        return result;
    }

    static int[] rotateArrayLeft(int[] A, int B) {

        int n = A.length;
        int g = gcd(n, B);
        int i, j, k, temp;

        for (i = 0; i < g; i++) {
            temp = A[i];
            j = i;
            while (true) {
                k = j + B;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                A[j] = A[k];
                j = k;
            }
            A[j] = temp;

        }
        return A;

    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }

    }

}

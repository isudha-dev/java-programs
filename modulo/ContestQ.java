package modulo;

public class ContestQ {

    public static void main(String[] args) {
        solve(new int[] { 1, 2, 3, 4, 12, 15, 18, 16, 17 }); // 1 2 1 4 4 1 2 16 1
    }

    static int[] solve(int[] A) {
        int[] B = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 1) {
                B[i] = 1;
            } else {
                B[i] = find(A[i]);
            }

        }
        return B;
    }

    static int find(int n) {
        int i = 0;
        while (true) {
            if ((n & (1 << i)) != 0) {
                return (int) Math.pow(2, i);
            }
            i++;
        }
    }
}

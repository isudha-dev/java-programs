package dsa.combinatorics;

public class ComputeNcR {

    public static void main(String[] args) {
        System.out.println(solve(1000000, 1, 999999));
    }

    static int solve(int A, int B, int C) {
        int[][] matrix = new int[A + 1][B + 1];
        for (int i = 0; i <= A; i++) {
            matrix[i][0] = 1 % C;
            matrix[i][1] = i % C;
            if (i <= B) {
                matrix[i][i] = 1 % C;
            }
        }
        if (B < 2) {
            return matrix[A][B];
        }
        for (int i = 3; i <= A; i++) {
            for (int j = 2; j <= B; j++) {
                matrix[i][j] = (int) (matrix[i - 1][j] % C + matrix[i - 1][j - 1] % C) % C;
            }
        }

        return matrix[A][B];
    }

}

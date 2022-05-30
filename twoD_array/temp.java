package twoD_array;

import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int q = scn.nextInt();
        scn.nextLine();

        int[][] matrix = new int[r][c];
        int num = 0;

        // creating matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = ++num;
            }
        }

        for (int i = 1; i <= q; i++) {
            int op = scn.nextInt();
            if (op == 1) {
                int c1 = scn.nextInt();
                int c2 = scn.nextInt();
                op1(matrix, c1 - 1, c2 - 1);
            } else if (op == 2) {
                int r1 = scn.nextInt();
                int r2 = scn.nextInt();
                op2(matrix, r1 - 1, r2 - 1);
            } else if (op == 3) {
                int r1 = scn.nextInt();
                int c1 = scn.nextInt();
                int r2 = scn.nextInt();
                int c2 = scn.nextInt();
                System.out.println(op3(matrix, r1 - 1, c1 - 1, r2 - 1, c2 - 1));
            } else if (op == 4) {
                int r1 = scn.nextInt();
                int c1 = scn.nextInt();
                int r2 = scn.nextInt();
                int c2 = scn.nextInt();
                System.out.println(op4(matrix, r1 - 1, c1 - 1, r2 - 1, c2 - 1));
            }
        }
        scn.nextLine();

    }

    static void op1(int[][] matrix, int c1, int c2) {

        for (int r = 0; r < matrix.length; r++) {
            int temp = matrix[r][c1];
            matrix[r][c1] = matrix[r][c2];
            matrix[r][c2] = temp;
        }

    }

    static void op2(int[][] matrix, int r1, int r2) {

        for (int c = 0; c < matrix[0].length; c++) {
            int temp = matrix[r1][c];
            matrix[r1][c] = matrix[r2][c];
            matrix[r2][c] = temp;
        }

    }

    static int op3(int[][] matrix, int r1, int c1, int r2, int c2) {

        return (matrix[r1][c1] | matrix[r2][c2]);

    }

    static int op4(int[][] matrix, int r1, int c1, int r2, int c2) {

        return (matrix[r1][c1] & matrix[r2][c2]);

    }

}

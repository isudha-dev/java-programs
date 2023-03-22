package dsa.primer;

public class SpiralOrderMatrix {
    // https://www.scaler.com/academy/mentee-dashboard/class/25553/assignment/problems/63?navref=cl_tt_nv
    public static void main(String[] args) {
        int[][] B = generateMatrix(5);

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int[][] generateMatrix(int A) {

        int[][] B = new int[A][A];
        int num = 0;

        int n = A;
        int i = 0, j = 0;
        while (n > 1) {

            for (int k = 1; k < n; k++) {
                B[i][j] = ++num;
                j++;
            }
            for (int k = 1; k < n; k++) {
                B[i][j] = ++num;
                i++;
            }
            for (int k = 1; k < n; k++) {
                B[i][j] = ++num;
                j--;
            }
            for (int k = 1; k < n; k++) {
                B[i][j] = ++num;
                i--;
            }
            n = n - 2;
            i++;
            j++;
        }
        if (n % 2 != 0) {
            B[i][j] = ++num;
        }

        return B;

    }

}

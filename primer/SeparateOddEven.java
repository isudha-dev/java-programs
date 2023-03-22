package primer;

import java.util.Scanner;

public class SeparateOddEven {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        scn.nextLine();

        int[][] result = new int[2][];
        for (int i = 0; i < T; i++) {
            int len = scn.nextInt();
            int[] A = new int[len];
            for (int j = 0; j < len; j++) {
                A[j] = scn.nextInt();
            }
            scn.nextLine();
            result = oddEven(A);
            for (int k = 0; k < result[1].length; k++) {
                if (result[1][k] != 0)
                    System.out.print(result[1][k] + " ");
            }
            System.out.println();
            for (int k = 0; k < result[0].length; k++) {
                if (result[0][k] != 0)
                    System.out.print(result[0][k] + " ");
            }
        }
        scn.close();

    }

    static int[][] oddEven(int[] A) {
        int[] odd = new int[A.length];
        int[] even = new int[A.length];
        int oIdx = 0, eIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even[eIdx] = A[i];
                eIdx++;
            } else {
                odd[oIdx] = A[i];
                oIdx++;
            }
        }
        return new int[][] { even, odd };

    }
}

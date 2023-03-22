package primer;

import java.util.*;

public class ReverseArray {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int A = scn.nextInt();

        int[] arrA = new int[A];
        for (int i = 0; i < A; i++) {
            arrA[i] = scn.nextInt();
        }
        scn.nextLine();

        int B = scn.nextInt();
        scn.close();

        int n = arrA.length;

        B = B % n;

        reverseArray(arrA, 0, n - 1);
        reverseArray(arrA, 0, B - 1);
        reverseArray(arrA, B, n - 1);

    }

    static int[] reverseArray(int[] arr, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }

        return arr;
    }

    static int[] solve(final int[] A) {

        int[] arr = A;

        return arr;
    }
}

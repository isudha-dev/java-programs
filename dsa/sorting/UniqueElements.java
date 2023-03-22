package dsa.sorting;

import java.util.Arrays;

public class UniqueElements {

    public static void main(String[] args) {

        System.out.println(solve1(new int[] { 51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14,
                23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69,
                54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14,
                80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62 }));

    }

    static int solve(int[] A) {

        Arrays.sort(A);
        int count = 0;
        boolean changed = false;
        int changedVal = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (changed && (changedVal == A[i + 1])) {
                changed = true;
                changedVal = A[i + 1] + 1;
                count++;

            } else if (A[i] == A[i + 1]) {
                changed = true;
                changedVal = A[i + 1] + 1;
                count++;
            } else {
                changed = false;
                changedVal = -1;
            }
        }

        return count;
    }

    static int solve1(int[] A) {

        Arrays.sort(A);
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                A[i + 1]++;
                count++;
            } else if (A[i] > A[i + 1]) {
                int diff = A[i] - A[i + 1];
                count += (diff + 1);
                A[i + 1] += (diff + 1);
            }

        }

        return count;
    }

}

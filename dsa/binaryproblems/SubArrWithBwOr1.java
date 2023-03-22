package dsa.binaryproblems;

public class SubArrWithBwOr1 {

    public static void main(String[] args) {
        System.out.println(solve(8, new int[] { 1, 1, 1, 1, 1, 1, 0 }));
    }

    static long solve(int A, int[] B) {
        A = B.length;

        int i = 0;
        long subArrayWithConsecutive0s = 0;
        long startOf0s = -1;
        long endOf0s = -1;
        long totalSa = A * (A + 1) / 2;

        while (i < A) {
            if (B[i] == 0) {
                if (startOf0s == -1) {
                    startOf0s = i;
                }
                if (i == A - 1 || B[i + 1] == 1) {
                    endOf0s = i;
                } else if (B[i + 1] == 0) {
                    endOf0s = i + 1;
                }
            }

            if (B[i] == 1 || i == A - 1) {
                if (startOf0s != -1 && endOf0s != -1) {
                    subArrayWithConsecutive0s = (endOf0s - startOf0s + 1) * (endOf0s - startOf0s + 1 + 1) / 2;
                    totalSa -= subArrayWithConsecutive0s;
                    startOf0s = -1;
                    endOf0s = -1;
                    subArrayWithConsecutive0s = 0;
                }
            }
            i++;

        }

        return totalSa;

    }

    static long solve1(int A, int[] B) {
        long count = 0;
        long last = 0;

        for (int i = 0; i < A; i++) {

            if (B[i] == 1) {
                last = i + 1;
            }

            count = count + last;

        }

        return count;

    }

}

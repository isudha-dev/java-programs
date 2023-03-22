package dsa.primer;

public class LittlePonnyMaxElem {

    public static void main(String[] args) {

        int[] A = { 2, 4, 3, 1, 5 };
        int B = 9;
        System.out.println(solve(A, B));

    }

    static int solve(int[] A, int B) {
        boolean exist = false;
        int count = 0;
        if (A.length == 0) {
            return -1;
        } else {

            for (int i = 0; i < A.length; i++) {
                if (A[i] > B) {
                    count++;
                }
                if (A[i] == B) {
                    exist = true;
                }
            }
        }
        if (exist) {
            return count;
        } else {
            return -1;
        }
    }

}

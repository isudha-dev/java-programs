package dsa.primer;

public class XOR {

    public static void main(String[] args) {
        solve(new int[] { 3, 4, 5 });
    }

    static int solve(int[] A) {

        int result = 0;
        int len = A.length;

        for (int i = 1; i <= len; i++) {
            int elem = i * (len - i + 1);
            if (elem % 2 != 0) {
                result = result ^ A[i - 1];
            }

        }

        return result;
    }

}

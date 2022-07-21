package binaryproblems;

public class DivideInteger {

    public static void main(String[] args) {
        divide(-2147483648, 1);
    }

    static int divide(int A, int B) {
        if (A == (1 << 31) && B == -1)
            return (1 << 31) - 1;
        int sign = (A < 0) ^ (B < 0) ? -1 : 1;
        long a = Math.abs(1L * A);
        long b = Math.abs(1L * B);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if (a - (b << i) >= 0) {
                res += 1 << i;
                a -= b << i;
            }
        }
        return res * sign;

    }
}

package Recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(pow(-1, 1, 20));
        // System.out.println(0 % 1); 71045970, 41535484, 64735492
    }

    static int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0)
            return 1 % C;
        long half_pow = pow(A, B / 2, C);
        long res = ((half_pow % C) * (half_pow % C)) % C;
        if (B % 2 == 0) {
            return (int) res;
        } else if (A < 0) {
            return (int) ((int) C + (((res % C) * (A % C)) % C));
        } else {
            return (int) (((res % C) * (A % C)) % C);
        }
    }
}
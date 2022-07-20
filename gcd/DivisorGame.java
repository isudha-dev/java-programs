package gcd;

public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(solve(411753753, 1876, 7430));
    }

    static int solve(int A, int B, int C) {
        int g = gcd(B, C);
        long multiply = (long) B * C;
        long lcm = multiply / g;

        return (int) ((long) A / lcm);
    }

    static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

}

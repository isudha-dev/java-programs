package dsa.modulo;

public class ABMod {

    public static void main(String[] args) {
        System.out.println(solve(6, 3406476));
    }

    static int solve(int A, int B) {
        if (A % B == 0) {
            return A - B;
        } else if (B % A == 0) {
            return B - A;
        } else {
            return Math.abs(A - B);
        }
    }
}

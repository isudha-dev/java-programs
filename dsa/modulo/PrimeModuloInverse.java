package dsa.modulo;

public class PrimeModuloInverse {

    public static void main(String[] args) {
        System.out.println(solve(1000000000, 88888800));
    }

    // 13 , 8
    static int solve(int A, int B) {
        int p = pow(A, B - 2, B);
        return p;
    }

    static int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }
        long res = pow(A, B / 2, C);
        if ((B & 1) == 1) {
            return (int) ((res % C * res % C * A % C) + C) % C;
        } else {
            return (int) ((res % C * res % C) + C) % C;
        }

    }

}

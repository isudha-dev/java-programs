package modulo;

public class VeryLargePower {

    public static void main(String[] args) {
        System.out.println(pow(71045970, 41535484, 64735492));
        // System.out.println(largePower(2, 20));
    }

    // 20805472
    private static int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }

        if (B == 0) {
            return 1;
        }

        long res = (long) pow(A, B / 2, C);

        if ((B & 1) == 1) {
            return (int) ((res % C * res % C * A % C) + C) % C;
        } else {
            return (int) ((res % C * res % C) + C) % C;
        }

    }

    private static int largePower(int A, int B) {
        int mod = 1000000007;
        int fact = 1;
        while (B != 1) {
            fact *= B % (mod - 1);
            B--;
        }

        return (int) pow(A, fact, mod);
    }

}

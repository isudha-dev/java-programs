package dsa.primer;

public class LCM {

    public static void main(String[] args) {
        System.out.println(LCMi(9, 6));
    }

    static int LCMi(int A, int B) {
        return (A * B) / gcd(A, B);
    }

    static int gcd(int A, int B) {
        if (A == 0) {
            return B;
        } else {
            return gcd(B % A, A);
        }
    }

}

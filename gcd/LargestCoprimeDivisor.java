package gcd;

public class LargestCoprimeDivisor {

    public static void main(String[] args) {

        System.out.println(cpFact(88, 2));
    }

    static int cpFact(int A, int B) {
        if (A % B == 0) {
            return A / B;
        }
        if (B % A == 0) {
            return 1;
        }
        if (isPrime(A)) {
            return A;
        }
        int maxAns = Integer.MIN_VALUE;
        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                int j = A / i;
                maxAns = gcd(i, B) == 1 ? Math.max(maxAns, i) : maxAns;
                maxAns = gcd(j, B) == 1 ? Math.max(maxAns, j) : maxAns;
            }
        }

        return maxAns;
    }

    static boolean isPrime(int A) {
        if (A == 1) {
            return false;
        }
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0) {
                return false;
            }
        }

        return true;
    }

    static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

}

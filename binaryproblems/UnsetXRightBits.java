package binaryproblems;

public class UnsetXRightBits {
    public static void main(String[] args) {
        System.out.println(solve(93, 4));
    }

    static long solve(long A, int B) {
        long copyOfA = A;

        for (int i = 1; i <= B; i++) {
            if ((copyOfA & 1) == 1) {
                A &= (A - 1);
            }
            copyOfA >>= 1;
        }

        return A;
    }
}

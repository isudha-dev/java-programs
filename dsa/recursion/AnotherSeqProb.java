package dsa.recursion;

public class AnotherSeqProb {

    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    static int solve(int A) {
        if (A == 0) {
            return 1;
        }
        if (A == 1) {
            return 1;
        }
        if (A == 2) {
            return 2;
        }

        return A + solve(A - 1) + solve(A - 2) + solve(A - 3);
    }

}

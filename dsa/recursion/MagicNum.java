package dsa.recursion;

public class MagicNum {

    public static void main(String[] args) {
        int A = 4397;
        while (A > 9) {
            A = solve(A);
        }
        if (A == 1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static int solve(int A) {
        if (A == 0) {
            return 0;
        }
        return solve(A / 10) + (A % 10);
    }

}

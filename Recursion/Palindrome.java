package Recursion;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(solve("malaqalam"));

    }

    static int solve(String A) {
        if (A.charAt(0) != A.charAt(A.length() - 1)) {
            return 0;
        } else if (A.length() == 2 || A.length() == 1) {
            return 1;
        }

        return solve(A.substring(1, A.length() - 1));
    }

}

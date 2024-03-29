package dsa.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    static int factorial(int A) {
        if (A <= 0)
            return 1;

        return factorial(A - 1) * A;
    }

}

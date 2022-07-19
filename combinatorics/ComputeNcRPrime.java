package combinatorics;

// https://www.scaler.com/academy/mentee-dashboard/class/29835/assignment/problems/4112?navref=cl_tt_nv
public class ComputeNcRPrime {

    public static void main(String[] args) {
        // System.out.println(factorial(5));
        System.out.println(solve(8458, 506, 540907));
    }

    static int solve(int A, int B, int C) {
        // nCr = n!/r!*(n-r)!
        int factA = 1;
        for (int i = 1; i <= A; i++) {
            long ans = ((long) factA * i) % C;
            factA = (int) ans;
        }

        int factB = 1;
        for (int i = 1; i <= B; i++) {
            long ans = ((long) factB * i) % C;
            factB = (int) ans;
        }

        int factAminusB = 1;
        int temp = A - B;
        for (int i = 1; i <= temp; i++) {
            long ans = ((long) factAminusB * i) % C;
            if (ans < 0) {
                System.out.println("Wait here");
            }
            factAminusB = (int) ans;
        }

        int arg1 = factA % C;
        int arg2 = pow(factB, C - 2, C);
        int arg3 = pow(factAminusB, C - 2, C);

        long mult1 = (long) arg1 * arg2 % C;
        long mult2 = (long) mult1 * arg3 % C;

        return (int) mult2;
    }

    static int pow(int a, int b, int c) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        long p = (long) pow(a, b / 2, c);
        if ((b & 1) == 1) {
            return (int) ((p % c * p % c * a % c) + c) % c;
        } else {
            return (int) ((p % c * p % c) + c) % c;
        }

    }

    static int factorial(int A, int C) {
        if (A == 0) {
            return 1;
        }
        long ans = (long) (A * factorial(A - 1, C));
        return (int) ans % C;
    }

}

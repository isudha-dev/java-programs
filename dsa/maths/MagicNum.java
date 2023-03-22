package dsa.maths;

// https://www.scaler.com/academy/mentee-dashboard/class/25561/assignment/problems/4105?navref=cl_tt_nv
public class MagicNum {

    public static void main(String[] args) {

        System.out.println(solve(3));

    }

    static int solve(int A) {
        int ans = 0;
        int pow = 5;
        while (A > 0) {
            ans = ans + (A & 1) * pow;
            pow = pow * 5;
            A = A >> 1;
        }

        return ans;
    }

}

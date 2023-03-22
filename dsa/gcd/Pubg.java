package dsa.gcd;

import java.util.ArrayList;

public class Pubg {

    public static void main(String[] args) {

    }

    static int solve(ArrayList<Integer> A) {

        if (A.size() == 1) {
            return A.get(0);
        }

        int ans = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            ans = gcd(ans, gcd(A.get(i), A.get(i + 1)));
        }
        return ans;
    }

    static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}

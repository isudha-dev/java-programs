package subsequence_subsets;

import java.util.ArrayList;

public class SubarrayOr {

    public static void main(String[] args) {
        System.out.println(solve1(new int[] { 78, 567, 98, 54, 3456 }));
    }

    static int solve(ArrayList<Integer> A) {
        double ans = 0;
        double subarrayOr;
        int n = A.size();
        int idx = 0;
        double p = Math.pow(10, 9) + 7;
        while (idx < n) {
            subarrayOr = A.get(idx);
            for (int i = idx; i < n; i++) {
                subarrayOr = (long) subarrayOr | A.get(i);
                ans = (ans % p + subarrayOr % p) % p;
            }

            idx++;
        }

        return (int) ans;
    }

    static int solve1(int[] A) {
        long sum = 0;
        int prev[] = new int[32]; // Creating array of 32 Bits which will be fill filled with 1 and not 0
        int mod = 1000000007;

        for (int i = 1; i <= A.length; i++) {
            int sum2 = A[i - 1];
            for (int j = 0; j < 32; j++) {
                long pow = (1 << j);// Left shifting 1, j times
                if ((sum2 & pow) != 0) {// if sum2 & pow != 0 than we add we add i in the array
                    sum = (sum + (pow * i) % mod) % mod; // calculating sum using mod
                    prev[j] = i; // add i in the array
                } else if (prev[j] != 0) {
                    sum = (sum + (pow * prev[j]) % mod) % mod;// if prev[j] != 0 than we calculate sum again.
                }
            }
        }

        return (int) (sum % mod); // taking mod for all subarray sum
    }

    static int solve2(ArrayList<Integer> A) {
        int n = A.size();
        int maxA = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, A.get(i));
        }
        for (int i = 0; i < Math.log(maxA); i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return 0;
    }
}

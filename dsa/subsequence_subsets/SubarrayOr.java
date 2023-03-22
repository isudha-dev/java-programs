package dsa.subsequence_subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayOr {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }))));
    }

    // 398980269 693947537
    static int solve(ArrayList<Integer> A) {
        long ans = 0;
        int n = A.size();
        long totalSubarrays = n * (n + 1) / 2;

        for (int i = 0; i < 32; i++) {
            long count0 = 0;
            long subarrayWithAll0 = 0;
            for (int j = 0; j < n; j++) {
                if ((A.get(j) & (1 << i)) == 0) {
                    count0 += 1;
                }
                if ((A.get(j) & (1 << i)) > 0 || j == n - 1) {
                    subarrayWithAll0 += (count0 * (count0 + 1)) / 2;
                    count0 = 0;
                }
            }

            ans += (totalSubarrays - subarrayWithAll0) * (long) Math.pow(2, i);
            ans = ans % 1000000007;
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

        return (int) (sum % mod); // taking mod for all dsa.subarray sum
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

    static int solve3(int[] A) {
        long n = A.length;
        long tot_subArray = (n * (n + 1)) / 2;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long subArray = 0;
            long bitzero = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) == 0) {
                    bitzero += 1;
                }
                if ((A[j] & (1 << i)) > 0 || j == n - 1) {
                    subArray += (bitzero * (bitzero + 1)) / 2;
                    bitzero = 0;
                }
            }
            ans += (tot_subArray - subArray) * (long) Math.pow(2, i);
            ans = ans % 1000000007;
        }
        return (int) ans;
    }
}

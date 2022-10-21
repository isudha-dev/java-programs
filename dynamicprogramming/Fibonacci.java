package dynamicprogramming;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int A = scn.nextInt();
        scn.close();

        int[] dp = new int[A + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int j = 2; j <= A; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }

        System.out.println(dp[A]);
    }

}

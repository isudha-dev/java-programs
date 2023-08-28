package dsa.contest.july08.tct1ReAttempt;

import java.util.Arrays;

public class InversionCount {

    // o(n^2) solution
    public int solve(int[] A) {

        int mod = 1000000007;
        int total = 0;
        int n = A.length;
        for(int i = 0; i<n-1; i++ ){
            for(int j = i+1; j<n; j++){
                if(A[i]>A[j]){
                    total = ((total % mod) + 1)%mod;
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {

    }

}

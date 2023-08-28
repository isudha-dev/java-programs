package dsa.contest.july08.tct1ReAttempt;

public class PaintersPartition {

    public int paint(int A, int B, int[] C) {

        int n = C.length;

        int max = Integer.MIN_VALUE;

        for(int i = 0; i< n; i++){
            max = Math.max(max, C[i]);
        }

        if(A >= n){
            return max*B;
        }

        int painterCount = 1;
        int i = 0;
        int sum = 0;
        while(painterCount<A  && i<n && sum<=max) {
            sum += C[i];



        }



        return 0;
    }

}

package submatrix;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSummatrixSum {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(new Integer[] { 1, 1, 1, 1, 1 })));
        A.add(new ArrayList<>(Arrays.asList(new Integer[] { 2, 2, 2, 2, 2 })));
        A.add(new ArrayList<>(Arrays.asList(new Integer[] { 3, 8, 6, 7, 3 })));
        A.add(new ArrayList<>(Arrays.asList(new Integer[] { 4, 4, 4, 4, 4 })));
        A.add(new ArrayList<>(Arrays.asList(new Integer[] { 5, 5, 5, 5, 5 })));

        System.out.println(solve(A, 3));
    }

    static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int ans = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < A.size(); r1++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int r2 = r1; r2 < A.size(); r2++) {
                for (int j = 0; j < A.get(0).size(); j++) {
                    int i = arr.get(j) + A.get(r2).get(j);
                    arr.set(j, i);
                    // arr[j] += A[r2][j];
                }
                ans = Math.max(ans, kadane(arr));
            }
        }

        return ans;
    }

    static int kadane(ArrayList<Integer> arr) {
        int n = arr.size();
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

}

package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSwaps {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 12, 10, 3, 14, 2, 5 }));
        System.out.println(solve(arr, 8));

    }

    static int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int countB = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) <= B) {
                countB++;
            }
        }

        int winCntB = 0;
        for (int i = 0; i < countB; i++) {
            if (A.get(i) <= B) {
                winCntB++;
            }
        }
        int minSwaps = countB - winCntB;
        for (int i = 1; i < n - countB + 1; i++) {
            if (A.get(i - 1) <= B) {
                winCntB--;
            }
            if (A.get(countB + i - 1) <= B) {
                winCntB++;
            }
            minSwaps = Math.min(minSwaps, countB - winCntB);

        }

        return minSwaps;
    }
}

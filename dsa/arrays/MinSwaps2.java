package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSwaps2 {

    public static void main(String[] args) {
        Integer[] arr = { 6, 2, 4, 3, 1, 0, 5 };

        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(arr))));

    }

    static int solve(ArrayList<Integer> A) {
        int n = A.size();
        int i = 0;
        int count = 0;
        while (i < n) {
            int swapNum = A.get(i);
            while (swapNum != i) {
                int temp = A.get(A.get(i));
                A.set(A.get(i), A.get(i));
                A.set(i, temp);
                swapNum = temp;
                count++;
            }
            i++;
        }
        return count;

    }

}

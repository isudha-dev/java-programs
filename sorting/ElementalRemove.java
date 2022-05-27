package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ElementalRemove {

    // https://www.scaler.com/academy/mentee-dashboard/class/25583/homework/problems/11087
    public static void main(String[] args) {

        System.out.println(solve(new ArrayList(Arrays.asList(new Integer[] { 2 }))));

    }

    static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        Collections.reverse(A);

        int totalSum = 0;
        for (int i = 0; i < A.size(); i++) {
            totalSum += A.get(i);
        }

        int minCost = totalSum;
        for (int i = 0; i < A.size(); i++) {
            totalSum -= A.get(i);
            minCost += totalSum;
        }

        return minCost;
    }

}

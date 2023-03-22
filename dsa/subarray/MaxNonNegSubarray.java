package dsa.subarray;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegSubarray {

    public static void main(String[] args) {
        System.out.println(maxset(new ArrayList<Integer>(
                Arrays.asList(new Integer[] { 24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438,
                        -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395,
                        19113, 71006, -97942, 42082, -30767, 85695, -73671 }))));
    }

    static ArrayList<Integer> maxset(ArrayList<Integer> A) {

        long sum = 0, maxSum = 0;
        ArrayList<Integer> maxList = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                sum += A.get(i);
                currList.add(A.get(i));
            } else {
                if (sum > maxSum || sum == maxSum && currList.size() > maxList.size()) {
                    maxSum = sum;
                    maxList = currList;
                }
                sum = 0;
                currList = new ArrayList<>();
            }
        }

        if (sum > maxSum || sum == maxSum && currList.size() > maxList.size())

        {
            maxSum = sum;
            maxList = currList;
        }

        return maxList;
    }

}

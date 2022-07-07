package submatrix;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/29823/assignment/problems/4091/submissions
public class SumOfAllSubmatrix {

    public static void main(String[] args) {

    }

    static int solve(ArrayList<ArrayList<Integer>> A) {
        int sum = 0;
        int n = A.size();
        int m = A.get(0).size();
        for (int r = 0; r < A.size(); r++) {
            for (int c = 0; c < A.get(0).size(); c++) {
                int frequency = (r + 1) * (n - 1) * (c + 1) * (m - 1);
                sum += frequency * A.get(r).get(c);
            }
        }

        return sum;
    }

}

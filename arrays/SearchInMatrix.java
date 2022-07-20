package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(Arrays.asList(new Integer[] { 2, 8, 8, 8 })));
        matrix.add(new ArrayList<>(Arrays.asList(new Integer[] { 2, 8, 8, 8 })));
        matrix.add(new ArrayList<>(Arrays.asList(new Integer[] { 2, 8, 8, 8 })));
        matrix.add(new ArrayList<>(Arrays.asList(new Integer[] { 2, 8, 8, 8 })));

        System.out.println(solve(matrix, 8));

    }

    static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int rows = A.size();
        int cols = A.get(0).size();
        for (int i = 0; i < rows; i++) {
            if (B >= A.get(i).get(0) && B <= A.get(i).get(cols - 1)) {
                for (int j = 0; j < cols; j++) {
                    if (B == A.get(i).get(j)) {
                        return (i + 1) * 1009 + (j + 1);
                    }
                }
            }
        }

        return -1;

    }

}

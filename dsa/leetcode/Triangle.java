package dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(new Integer[] { 2 }));
        triangle.add(A);
        A = new ArrayList<>(Arrays.asList(new Integer[] { 3, 4 }));
        triangle.add(A);
        A = new ArrayList<>(Arrays.asList(new Integer[] { 6, 5, 7 }));
        triangle.add(A);
        A = new ArrayList<>(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
        triangle.add(A);

        System.out.println(minimumTotal(triangle));
    }

    static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> minlen = triangle.get(n - 1);

        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                int val = (Math.min(minlen.get(i), minlen.get(i + 1))) + triangle.get(j).get(i);
                minlen.remove(i);
                minlen.add(i, val);
            }
        }

        return minlen.get(0);
    }

}

package dsa.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BeggersOutsideTemple {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(new Integer[] { 1, 3, 10 })));
        B.add(new ArrayList<>(Arrays.asList(new Integer[] { 6, 9, 2 })));
        B.add(new ArrayList<>(Arrays.asList(new Integer[] { 3, 5, 3 })));
        B.add(new ArrayList<>(Arrays.asList(new Integer[] { 2, 8, 4 })));
        B.add(new ArrayList<>(Arrays.asList(new Integer[] { 6, 7, 5 })));
        System.out.println(solve(10, B));
    }

    static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] beggers = new int[A];
        for (int i = 0; i < B.size(); i++) {

            beggers[B.get(i).get(0) - 1] += B.get(i).get(2);

            if (B.get(i).get(1) < beggers.length) {
                beggers[B.get(i).get(1)] -= B.get(i).get(2);
            }
        }

        // calculate prefix sum
        int sum = 0;
        for (int i = 0; i < A; i++) {
            sum += beggers[i];
            beggers[i] = sum;
        }

        return new ArrayList<Integer>(Arrays.stream(beggers).boxed().collect(Collectors.toList()));
    }

}
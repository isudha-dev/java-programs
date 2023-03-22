package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PrintAllSubsets {

    public static void main(String[] args) {
        PrintAllSubsets ps = new PrintAllSubsets();
        System.out.println(ps.subsets(new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 2 }))));
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        subsets(0, new ArrayList<>(), A.size(), A);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int min = Math.min(o1.size(), o2.size());
                for (int i = 0; i < min; i++) {
                    if (o1.get(i) != o2.get(i)) {
                        return o1.get(i).compareTo(o2.get(i));
                    }
                }
                return (o1.size() <= o2.size()) ? -1 : 1;
            }
        });
        return res;
    }

    public void subsets(int i, ArrayList<Integer> subsets, int n, ArrayList<Integer> A) {
        if (i == n) {
            res.add(new ArrayList<>(subsets));
            return;
        }
        // choice - dont choose elem at index i
        subsets(i + 1, subsets, n, A);

        // choice - select elem at index 1
        subsets.add(A.get(i));
        subsets(i + 1, subsets, n, A);
        subsets.remove(subsets.size() - 1);
    }

}

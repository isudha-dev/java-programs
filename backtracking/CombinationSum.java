package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CombinationSum {

    // TODO ability to select same repeated number from A unlimited number of times.
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.combinationSum(new ArrayList<>(Arrays.asList(new Integer[] { 2, 3, 4, 7 })), 7);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        generateSum(0, A, B, new ArrayList<>(), res);

        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int n = Math.max(o1.size(), o2.size());
                for (int i = 0; i < n; i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i).compareTo(o2.get(i));
                }
                return (o1.size() <= o2.size()) ? -1 : 1;
            }
        });
        return res;
    }

    void generateSum(int i, ArrayList<Integer> A, int B, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (i == A.size()) {
            if (B == 0) {
                res.add(new ArrayList<>(temp));
                return;
            } else {
                return;
            }
        }
        if (B == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // choose i
        temp.add(A.get(i));
        generateSum(i + 1, A, B - A.get(i), temp, res);
        temp.remove(temp.size() - 1);

        // dont choose i
        generateSum(i + 1, A, B, temp, res);
    }

}

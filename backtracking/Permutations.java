package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.permute(new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3 })));
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        // initialising arraylist with default value
        List<Integer> temp = new ArrayList<Integer>(Collections.nCopies(A.size(), -1));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        generatePermutations(0, new ArrayList<>(temp), A, ans);

        return ans;
    }

    public void generatePermutations(int ind, ArrayList<Integer> temp, ArrayList<Integer> A,
            ArrayList<ArrayList<Integer>> ans) {

        if (ind == A.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = 0; j < A.size(); j++) {
            if (temp.get(j) == -1) {
                temp.set(j, A.get(ind));
                generatePermutations(ind + 1, temp, A, ans);
                temp.set(j, -1);
            }
        }
        return;
    }

}

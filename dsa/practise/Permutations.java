package dsa.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] A) {
        List<Integer> temp = new ArrayList<>(Collections.nCopies(A.length, -1));
        List<List<Integer>> ans = new ArrayList<>();

        generatePermutations(0, new ArrayList<>(temp), A, ans);

        return ans;
    }

    public void generatePermutations(int ind, ArrayList<Integer> temp, int[] A,
        List<List<Integer>> ans) {

        if (ind == A.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = 0; j < A.length; j++) {
            if (temp.get(j) == -1) {
                temp.set(j, A[ind]);
                generatePermutations(ind + 1, temp, A, ans);
                temp.set(j, -1);
            }
        }
    }
}

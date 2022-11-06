package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class AllUniquePermutations {

    public static void main(String[] args) {
        AllUniquePermutations up = new AllUniquePermutations();
        System.out.println(up.permute(new ArrayList<>(Arrays.asList(new Integer[] { 1, 2 }))));
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            temp.add(-1);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generateAllPerm(0, temp, A, ans, new HashSet<>(), new StringBuilder());

        return ans;
    }

    public void generateAllPerm(int idx, ArrayList<Integer> temp, ArrayList<Integer> A,
            ArrayList<ArrayList<Integer>> ans, HashSet<String> hs, StringBuilder sb) {

        if (idx == A.size()) {
            System.out.println(temp);
            if (!ans.contains(temp))
                ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < A.size(); j++) {
            if (temp.get(j) == -1) {
                temp.set(j, A.get(idx));
                String s = "" + A.get(idx);
                sb.append(s);
                generateAllPerm(idx + 1, temp, A, ans, hs, sb);
                temp.set(j, -1);
                sb.delete(sb.length() - s.length(), sb.length());
            }
        }
    }
}

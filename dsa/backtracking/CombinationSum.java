package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(
                cs.combinationSum(new ArrayList<>(Arrays.asList(new Integer[] { 1 })), 5));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        A = (ArrayList<Integer>) A.stream().distinct().collect(Collectors.toList());

        generateSum(0, A, B, new ArrayList<>(), res, new HashSet<String>(), new StringBuilder());

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

    void generateSum(int i, ArrayList<Integer> A, int B, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res,
            HashSet<String> hs, StringBuilder sb) {
        if (B < 0)
            return;

        if (i == A.size()) {
            if (B == 0) {
                if (!hs.contains(sb.toString()))
                    res.add(new ArrayList<>(temp));
                return;
            }
            return;
        }
        if (B == 0) {
            if (!hs.contains(sb.toString()))
                res.add(new ArrayList<>(temp));
            return;
        }

        // for loop
        for (int k = i; k < A.size(); k++) {
            int currElem = A.get(k);

            temp.add(currElem);
            sb.append(currElem);
            generateSum(k, A, B - currElem, temp, res, hs, sb);
            temp.remove(temp.size() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Subsets2 {

    public static void main(String[] args) {
        Subsets2 ps = new Subsets2();
        System.out.println(ps.subsets(new ArrayList<>(Arrays.asList(new Integer[] { 6, 6, 3, 3, 6, 5 }))));
    }

    // [] [3 ] [3 3 ] [3 3 5 ] [3 3 5 6 ] [3 3 5 6 6 ] [3 3 5 6 6 6 ] [3 3 6 ] [3 3
    // 6 6 ] [3 3 6 6 6 ] [3 5 ] [3 5 6 ] [3 5 6 6 ] [3 5 6 6 6 ] [3 6 ] [3 6 6 ] [3
    // 6 6 6 ] [5 ] [5 6 ] [5 6 6 ] [5 6 6 6 ] [6 ] [6 6 ] [6 6 6 ]

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        subsets(0, new ArrayList<>(), A.size(), A, new HashSet<>(), new StringBuilder());
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

    public void subsets(int i, ArrayList<Integer> subsets, int n, ArrayList<Integer> A, HashSet<String> hs,
            StringBuilder sb) {
        if (i == n) {
            if (!hs.contains(sb.toString())) {
                hs.add(sb.toString());
                res.add(new ArrayList<>(subsets));
            }
            return;
        }
        // choice - dont choose elem at index i
        subsets(i + 1, subsets, n, A, hs, sb);

        // choice - select elem at index 1
        subsets.add(A.get(i));
        String s = "" + A.get(i);
        sb.append(A.get(i));
        subsets(i + 1, subsets, n, A, hs, sb);
        subsets.remove(subsets.size() - 1);
        sb.delete(sb.length() - s.length(), sb.length());
    }

}

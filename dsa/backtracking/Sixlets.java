package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Sixlets {
    public static void main(String[] args) {
        Sixlets st = new Sixlets();
        st.solve(new ArrayList<>(Arrays.asList(new Integer[] { 999, 999, 999, 999, 999, 999, 999, 999, 999, 999 })), 5);
    }

    public int solve(ArrayList<Integer> A, int B) {
        int ans = countSumMoreThan1000(0, A, new ArrayList<>(), 0, B);
        return ans;
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    int countSumMoreThan1000(int i, ArrayList<Integer> A, ArrayList<Integer> temp, int sum, int B) {
        if (temp.size() == B) {
            if (sum <= 1000) {
                res.add(new ArrayList<>(temp));
                return 1;
            } else {
                return 0;
            }
        }
        if (sum > 1000 || i == A.size()) {
            return 0;
        }

        // choose i
        temp.add(A.get(i));
        sum += A.get(i);
        int x = countSumMoreThan1000(i + 1, A, temp, sum, B);
        sum = sum - A.get(i);
        temp.remove(temp.size() - 1);

        // dont choose i
        int y = countSumMoreThan1000(i + 1, A, temp, sum, B);

        return x + y;
    }
}

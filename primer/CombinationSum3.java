package primer;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {
        CombinationSum3 cs = new CombinationSum3();
        List<List<Integer>> ans = cs.combinationSum3(3, 9);
        System.out.println(ans);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        int smallestSum = k * (k + 1) / 2;
        if (smallestSum > n) {
            return ans;
        }

        findNums(k, n, 1, new ArrayList<Integer>(), ans);

        return ans;
    }

    private void findNums(int k, int n, int start, List<Integer> currList, List<List<Integer>> ans) {

        if (currList.size() > k)
            return;
        else if (currList.size() == k && n == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (int i = start; i <= 9 && i <= n; i++) {
            currList.add(i);
            findNums(k, n - i, i + 1, currList, ans);
            currList.remove(currList.size() - 1);
        }
    }
}

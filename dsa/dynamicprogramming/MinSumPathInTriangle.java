package dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {

    public static void main(String[] args) {
        MinSumPathInTriangle ms = new MinSumPathInTriangle();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(new Integer[] { 2 }));
        a.add(temp);
        temp = new ArrayList<>(Arrays.asList(new Integer[] { 3, 4 }));
        a.add(temp);
        temp = new ArrayList<>(Arrays.asList(new Integer[] { 6, 5, 7 }));
        a.add(temp);
        temp = new ArrayList<>(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
        a.add(temp);

        ms.minimumTotal(a);

    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        int l1 = a.size();
        int l2 = a.get(l1 - 1).size();

        int[][] dp = new int[l1][l2];

        // initalizing to int max
        for (int i = 0; i < l1; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        // prefilling 1st col
        dp[0][0] = a.get(0).get(0);
        for (int i = 1; i < l1; i++)
            dp[i][0] = a.get(i).get(0) + dp[i - 1][0];

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < a.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + a.get(i).get(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < l2; i++) {
            ans = Math.min(ans, dp[l1 - 1][i]);
        }

        return ans;
    }

}

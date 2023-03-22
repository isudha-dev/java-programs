package dsa.hashing;

import java.util.HashMap;

// https://www.scaler.com/academy/mentee-dashboard/class/29857/assignment/problems/333?navref=cl_tt_lst_nm
public class DistinctNumInRange {

    public static void main(String[] args) {
        int[] A = new int[] { 1, 2, 1, 3, 4, 3 };
        dNums(A, 3);
    }

    public static int[] dNums(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = A.length;

        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        int[] ans = new int[N - B + 1];
        int idx = 0;
        ans[idx] = map.size();
        idx++;

        for (int i = 0; i < (N - B); i++) {
            map.put(A[i], map.get(A[i]) - 1);
            if (map.get(A[i]) == 0) {
                map.remove(A[i]);
            }
            map.put(A[i + B], map.getOrDefault(A[i + B], 0) + 1);
            ans[idx] = map.size();
            idx++;
        }

        return ans;
    }

}

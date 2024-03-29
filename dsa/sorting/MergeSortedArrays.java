package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {

    public static void main(String[] args) {

        solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { -4, 3 })),
                new ArrayList<Integer>(Arrays.asList(new Integer[] { -2, -2 })));
    }

    static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int m = B.size();
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (A.get(p1) < B.get(p2)) {
                ans.add(A.get(p1));
                p1++;
            } else {
                ans.add(B.get(p2));
                p2++;
            }
        }
        while (p1 < n) {
            ans.add(A.get(p1));
            p1++;
        }
        while (p2 < m) {
            ans.add(B.get(p2));
            p2++;
        }

        return ans;
    }

    static int[] mergeSortedArray(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[] ans = new int[n + m];

        int p1 = 0, p2 = 0, idx = 0;
        while (p1 < n && p2 < m) {
            if (A[p1] < B[p2]) {
                ans[idx] = A[p1];
                idx++;
                p1++;
            } else {
                ans[idx] = B[p2];
                idx++;
                p2++;
            }
        }
        while (p1 < n) {
            ans[idx] = A[p1];
            p1++;
            idx++;
        }
        while (p2 < m) {
            ans[idx] = B[p2];
            idx++;
            p2++;
        }
        return ans;

    }

}
package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NPairsMaxSum {

    public static void main(String[] args) {
        NPairsMaxSum ns = new NPairsMaxSum();
        ArrayList<Integer> ans = ns.solve(new ArrayList<>(Arrays.asList(new Integer[] { 36, 27, -35, 43, -15, 36, 42,
                -1, -29, 12, -23, 40, 9,
                13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43,
                6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45,
                -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28 })),
                new ArrayList<>(Arrays.asList(new Integer[] { 38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36,
                        44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31,
                        -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21,
                        -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22,
                        -9, 0, 43 })));

        System.out.println(ans);
    }

    // 97 95 95 95 95 94 94 93 93 93 93 92 92 92 92 92 92 92 91 91 91 91 90 90 90 90
    // 90 90 90 90 90 90 89 89 89 89 89 89 89 89 88 88 88 88 88 88 88 88 87 87 87 87
    // 87 87 87 87 87 86 86 86 86 86 86 86 86 85 85 85 85 85 85 85 85 84 84 84 84 84
    // 84 84 84 84 84

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int p1 = 0, p2 = 0;
        Collections.sort(A, Comparator.reverseOrder());
        Collections.sort(B, Comparator.reverseOrder());
        PriorityQueue<PairWithSum> pq = new PriorityQueue<>((a, b) -> (b.sum - a.sum));
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int sum = A.get(p1) + B.get(p2);
        pq.add(new PairWithSum(sum, p1, p2));
        ans.add(pq.poll().sum);
        String setString1, setString2;
        set.add(p1 + "-" + p2);

        for (int i = 1; i < n; i++) {

            int sum1 = A.get(p1) + B.get(p2 + 1);
            int sum2 = A.get(p1 + 1) + B.get(p2);
            setString1 = p1 + "-" + (p2 + 1);
            setString2 = (p1 + 1) + "-" + p2;

            if (!set.contains(setString1)) {
                pq.add(new PairWithSum(sum1, p1, p2 + 1));
                set.add(setString1);
            }
            if (!set.contains(setString2)) {
                pq.add(new PairWithSum(sum2, p1 + 1, p2));
                set.add(setString2);
            }
            PairWithSum top = pq.poll();
            ans.add(top.sum);
            p1 = top.p1;
            p2 = top.p2;
        }

        return ans;
    }

    class PairWithSum {
        int sum, p1, p2;

        PairWithSum(int sum, int p1, int p2) {
            this.sum = sum;
            this.p1 = p1;
            this.p2 = p2;
        }
    }

}
package prefix_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubarrayWithSum0 {

    public static void main(String[] args) {

        // System.out.println(lszero2(new ArrayList<Integer>(Arrays.asList(new Integer[]
        // { 1, 2, -2, 4, -4 }))));
        System.out.println(lszero3(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, -2, 4, -4 }))));
    }

    static ArrayList<Integer> lszero1(ArrayList<Integer> A) {
        ArrayList<Integer> ps = new ArrayList<>();
        int sum = 0;

        for (Integer i : A) {
            sum += i;
            ps.add(sum);
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        int startIdx = -1;
        int endIdx = -1;
        int maxlen = Integer.MIN_VALUE;
        for (int i = 0; i < ps.size(); i++) {
            if (hm.containsKey(ps.get(i))) {
                int len = i - hm.get(ps.get(i));
                if (len > maxlen) {
                    startIdx = hm.get(ps.get(i));
                    maxlen = len;
                    endIdx = i;
                }
            } else {
                if (ps.get(i) == 0) {
                    hm.put(ps.get(i), -1);
                    int len = i - startIdx;
                    if (len > maxlen) {
                        maxlen = len;
                        endIdx = i;
                    }
                } else {
                    hm.put(ps.get(i), i);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = startIdx + 1; i <= endIdx; i++) {
            ans.add(A.get(i));
        }

        return ans;
    }

    static ArrayList<Integer> lszero2(ArrayList<Integer> A) {
        Integer sum = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        int startIdx = -1;
        int endIdx = -1;
        int maxlen = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (hm.containsKey(sum)) {
                int len = i - hm.get(sum);
                if (len > maxlen) {
                    startIdx = hm.get(sum);
                    maxlen = len;
                    endIdx = i;
                }
            } else {
                if (sum == 0) {
                    hm.put(sum, -1);
                    int len = i - startIdx;
                    if (len > maxlen) {
                        maxlen = len;
                        endIdx = i;
                    }
                } else {
                    hm.put(sum, i);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = startIdx + 1; i <= endIdx; i++) {
            ans.add(A.get(i));
        }

        return ans;
    }

    static int lszero3(ArrayList<Integer> A) {
        Integer sum = 0;

        HashSet<Integer> hm = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum == 0) {
                return 1;
            }
            if (hm.contains(sum)) {
                return 1;
            } else {
                hm.add(sum);
            }
        }
        return 0;
    }

}

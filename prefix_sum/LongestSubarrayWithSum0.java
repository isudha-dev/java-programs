package prefix_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubarrayWithSum0 {

    public static void main(String[] args) {

        // System.out.println(lszero2(new ArrayList<Integer>(Arrays.asList(new Integer[]
        // { 1, 2, -2, 4, -4 }))));
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 81760, 79550, 22559, 75299, 16955,
                88462, 61786, 75867, 70648, 3369, 22975, 96532, 25025, 66395, 93487, 99745, 18113, 53612, 27186, 46537,
                45321, 66174, 17988, 41507, 1917, 17613, 20118, 97218, 49013, 69220, 7583, 17748, 64613, 99073, 32976,
                84997, 96961, 1757, 9565, 19937, 20844, 52727, 84400, 2459, 29910, 92266, 56997, 95895, 14078, 62465,
                56931, 58056, 31338, 85194, 35782, 85090, 75386, 13941, 4115, 25904, 20784, 87872, 60888, 48447, 95087,
                54725, 91079, 22263, 88947, 79672, 45292, 81355, 18933, 29522, 44401, 73426, 6301, 75670, 77769, 58508,
                67734, 41227, 26015, 97582, 3651, 56043, 74721, 18679, 65400, 33055, 19979, 7691, 484, 93470, 40183,
                67462, 81564, 99434, 4884, 38894 }))));
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
        Long sum = 0L;

        HashSet<Long> hm = new HashSet<>();
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

    static int solve(ArrayList<Integer> A) {
        int minLen = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            if (hm.containsKey(A.get(i))) {
                int len = i - hm.get(A.get(i));
                minLen = Math.min(minLen, len);
            } else {
                hm.put(A.get(i), i);
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

}

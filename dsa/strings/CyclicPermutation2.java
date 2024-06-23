package dsa.strings;

import java.util.List;

public class CyclicPermutation2 {

    public static int solve(String A, String B) {
        String str = A + A.substring(0, A.length()-1);

        List<Integer> ans = ZAlgo.zAlgo(B+"$"+str);
        int n = B.length();

        return (int) ans.stream().filter(i -> i==n).count();
    }
}

package dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class PointsOnSameLine {

    public static void main(String[] args) {
        int[] A = { -1, 0, 1, 2, 3, 3 };
        int[] B = { 1, 0, 1, 2, 3, 4 };

        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int[] B) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
            int equal = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j] && B[j] == B[i])
                    equal++;
                else {
                    int y = B[i] - B[j];
                    int x = A[i] - A[j];
                    int g = gcd(y, x);
                    String str = (x / g) + "_" + (y / g);
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
            res = Math.max(res, equal);
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + equal);
            }
            map.clear();
        }
        return res;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}

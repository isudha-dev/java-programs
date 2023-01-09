import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RepeatMissingNum {

    public static void main(String[] args) {
        System.out.println(repeatedNumber(new int[] { 3, 1, 2, 3, 4 }));
    }

    static int[] repeatedNumber(final int[] A) {
        long n = A.length;
        System.out.println(n);
        long expectedSum = n * (n + 1) / 2;
        long actualSum = 0l;

        Map<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hMap.containsKey(A[i])) {
                int freq = hMap.get(A[i]) + 1;
                hMap.put(A[i], freq);
            } else {
                hMap.put(A[i], 1);
            }
            actualSum = (long) actualSum + (long) A[i];
        }

        int[] ans = new int[2];
        for (Entry<Integer, Integer> entry : hMap.entrySet()) {
            if (entry.getValue().equals(2)) {
                ans[0] = entry.getKey();
                break;
            }
        }

        ans[1] = (int) (ans[0] + (expectedSum - actualSum));

        return ans;
    }

}

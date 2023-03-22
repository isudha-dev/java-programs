package dsa.stack;

import java.util.HashMap;
import java.util.Stack;

public class MaxFreqStack {

    public static void main(String[] args) {
        int[][] A = new int[][] { { 1, 5 }, { 1, 7 }, { 1, 5 }, { 1, 7 }, { 1, 4 }, { 1, 5 }, { 2, 0 }, { 2, 0 },
                { 2, 0 }, { 2, 0 } };

        int[] ans = solve(A);
        System.out.println(ans);

    }

    public static int[] solve(int[][] A) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Stack<Integer>> valueMap = new HashMap<>();
        int maxFreq = 0;
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                // push
                freqMap.put(A[i][1], freqMap.getOrDefault(A[i][1], 0) + 1);
                maxFreq = Math.max(maxFreq, freqMap.get(A[i][1]));
                int currFreq = freqMap.get(A[i][1]);
                Stack<Integer> tempStack = valueMap.get(currFreq);
                if (tempStack == null) {
                    tempStack = new Stack<>();
                }
                tempStack.push(A[i][1]);
                valueMap.put(currFreq, tempStack);
                ans[i] = -1;
            }
            if (A[i][0] == 2) {
                // pop
                Stack<Integer> tempStack = valueMap.get(maxFreq);
                int max = tempStack.pop();
                ans[i] = max;
                if (tempStack.isEmpty()) {
                    maxFreq--;
                }
                int currFreq = freqMap.get(max);
                freqMap.put(max, --currFreq);
            }
        }

        return ans;
    }

}

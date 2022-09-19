package stack;

import java.util.Stack;

public class AllSubarrays {

    public static void main(String[] args) {
        System.out.println(solve(new int[] {3,1,4}));
    }

    public static int solve(int[] A) {
        int ans = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i<A.length;i++){
            while(!s.empty()) {
                ans = Math.max(ans, A[i]^A[s.peek()]);
                if(A[s.peek()] > A[i]) {
                    break;
                }
                s.pop();
            }
            s.push(i);

        }

        return ans;
    }
    
}

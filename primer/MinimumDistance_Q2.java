package primer;

public class MinimumDistance_Q2 {

    public static void main(String args[]) {

        String[] A = { "aaa", "aaa", "aaab", "b", "bab", "bbaa", "bbaaa", "bbbb", "bbbbb" };
        int[] ans = solve(A, "aaa");
        System.out.println(ans[0] + " " + ans[1]);

    }

    static int[] solve(String[] A, String B) {
        int start = -1;
        int end = -1;

        for (int i = 0; i < A.length; i++) {
            int j = A[i].compareTo(B);
            if (j == 0 || j > 0 && A[i].startsWith(B)) {
                if (start == -1) {
                    start = i;
                }
                if (start != -1) {
                    end = i;
                }
            }

        }

        return new int[] { start, end };
    }

}

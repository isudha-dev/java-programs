package binaryproblems;

public class HelpFromSam {
    public static void main(String[] args) {
        System.out.println(solve(9));

    }

    static int solve(int A) {
        int ans = 0;
        while (A > 0) {
            if ((A & 1) > 0) {
                ++ans;
            }
            A >>= 1;
        }
        return ans;
    }

}

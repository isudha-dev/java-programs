package dsa.primer;

public class PerfectSqaure {
    public static void main(String[] args) {
        System.out.println(solve(121));
    }

    static int solve(int A) {
        for (int i = 2; i * i <= A; i++) {
            if (i == i / 2) {
                return i;
            }
        }
        return -1;
    }

}

package binaryproblems;

public class CountTotalSetBits {

    public static void main(String[] args) {
        System.out.println(solve1(100000000));
    }

    // exp 314447109 val 100000000 act
    // this solution gives TLE
    static int solve(int A) {

        int mod = 1000000007;
        long res = 0;

        // int log = (int) (Math.log(A) / Math.log(2)) + 1;
        for (int i = 0; i < 32; i++) {
            long count1 = 0;
            for (int j = 1; j <= A; j++) {
                if ((j & (1 << i)) > 0) {
                    count1++;
                }
            }
            res = (res + count1 % mod) % mod;
        }
        return (int) res;
    }

    static int solve1(int A) {
        int mod = 1000000007;
        long count1 = 0;

        for (int j = 1; j <= A; j++) {
            int i = j;
            while (i != 0) {
                count1++;
                i = i & (i - 1);
            }
            count1 = count1 % mod;
        }

        return (int) count1;
    }

}

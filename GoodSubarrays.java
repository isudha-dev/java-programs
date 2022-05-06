public class GoodSubarrays {

    public static void main(String[] args) {
        System.out.println(solve(new int[] { 13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9 }, 65));
    }

    static int solve(int[] A, int B) {
        int n = A.length;
        int[] ps = new int[n];

        ps[0] = A[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + A[i];
        }

        int count = 0;
        long sum = 0;
        boolean even;
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                sum = getPSRangeSum(ps, i, j);
                even = ((j - i) % 2 != 0) ? true : false;
                if (!even && sum > B) {
                    count++;
                } else if (even && sum < B) {
                    count++;
                }
            }
        }

        return count;
    }

    static long getPSRangeSum(int[] ps, int s, int e) {

        if (s == 0) {
            return ps[e];
        } else {
            return ps[e] - ps[s - 1];
        }
    }

}

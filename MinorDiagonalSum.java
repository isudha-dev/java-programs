public class MinorDiagonalSum {

    public static void main(String[] args) {

        int sum = solve(new int[][] { { 3, 2 }, { 2, 3 } });
        System.out.println(sum);

    }

    static int solve(final int[][] A) {
        int n = A.length;
        int r = 0, c = n - 1;
        int sum = 0;
        while (r <= n - 1) {
            sum += A[r][c];
            r++;
            c--;
        }
        return sum;
    }

}

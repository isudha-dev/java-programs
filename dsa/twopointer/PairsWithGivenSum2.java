package dsa.twopointer;

public class PairsWithGivenSum2 {

    public static void main(String[] args) {
        PairsWithGivenSum2 pw = new PairsWithGivenSum2();
        pw.solve(new int[] { 2, 3, 5, 6, 10 }, 6);
        System.out.println();
    }

    public int solve(int[] A, int B) {
        int mod = 1000000007;
        int n = A.length;
        int p1 = 0, p2 = n - 1;
        int count = 0;

        while (p1 < p2) {
            if (A[p1] + A[p2] > B) {
                p2--;
            } else if (A[p1] + A[p2] < B) {
                p1++;
            } else {
                int x = 0, y = 0;
                if (A[p1] != A[p2]) {
                    int left = p1;
                    while (A[left] == A[p1]) {
                        p1++;
                        x++;
                    }
                    int right = p2;
                    while (A[right] == A[p2]) {
                        p2--;
                        y++;
                    }
                    count += ((x * y) % mod);
                } else {
                    int freq = p2 - p1 + 1;
                    count += ((freq * (freq - 1)) / 2) % mod;
                    break;
                }
            }
        }

        return count % mod;
    }

}

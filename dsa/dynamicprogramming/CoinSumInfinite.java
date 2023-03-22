package dsa.dynamicprogramming;

public class CoinSumInfinite {
    public static void main(String[] args) {
        CoinSumInfinite csi = new CoinSumInfinite();
        csi.coinchange2(new int[] { 1, 2, 3 }, 4);
    }

    public int coinchange2(int[] A, int B) {
        int mod = 1000007;
        int[] ways = new int[B + 1];
        ways[0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int b = 1; b <= B; b++) {
                if (A[i] <= b) {
                    ways[b] = (ways[b] % mod + ways[b - A[i]] % mod) % mod;
                }
            }
        }
        return ways[B];
    }
}

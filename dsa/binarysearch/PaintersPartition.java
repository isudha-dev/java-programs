package dsa.binarysearch;

public class PaintersPartition {

    public static void main(String[] args) {
        PaintersPartition pp = new PaintersPartition();
        pp.paint(1, 1000000, new int[] { 1000000, 1000000 });
    }

    public int paint(int A, int B, int[] C) {
        int sum = 0, max = 0;

        for (int i = 0; i < C.length; i++) {
            sum += C[i];
            max = Math.max(max, C[i]);
        }

        long low = max, high = sum;
        long ans = 0;

        while (low <= high) {
            long mid = (long) (low + high) / 2;
            if (check(C, A, B, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int mod = 10000003;
        ans %= mod;
        ans = (ans * B % mod) % mod;
        return (int) ans;
    }

    public boolean check(int[] C, int A, int B, long mid) {
        int painters = 1;
        int time = 0;
        for (int i = 0; i < C.length; i++) {
            time += C[i];
            if (time > mid) {
                painters++;
                time = C[i];
            }
        }
        if (painters > A)
            return false;
        return true;

    }

}

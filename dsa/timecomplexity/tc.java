package dsa.timecomplexity;

public class tc {

    public static void main(String[] args) {
        solve3(10000);
    }

    public static void solve1(int n) {
        int count = 0;
        int i = n;
        while (i > 0) {
            System.out.println("i = " + i);
            if (i % 2 == 0) {
                for (int j = 1; j <= n * n; j += 2) {
                    // O(1) operation
                    System.out.println("i = " + i + " j = " + j);
                    count++;
                }
            }
            i /= 2;
        }
        System.out.println(count);
    }

    public static void solve2(int n) {
        int count = 0;
        for (int i = 0; i < 50; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < i / 2; j++) {
                count++;
                System.out.println("i = " + i + " j = " + j);
            }
        }
        System.out.println(count);
    }

    public static void solve3(int N) {
        int count = 0;
        for (int i = N; i > 0; i /= 2) {
            // System.out.println("i = " + i);
            for (int j = 0; j < i; j++) {
                count++;
                // System.out.println("i = " + i + " j = " + j);
            }
        }
        System.out.println(count);
    }

}

package binarysearch;

public class AthMagicalNum {

    public static void main(String[] args) {
        AthMagicalNum mg = new AthMagicalNum();
        System.out.println(mg.solve(827802315, 12423, 7916));

    }

    // exp 678065970 act 0
    public int solve(int A, int B, int C) {
        int mod = 1000000007;
        long low = 1;
        long high = (Math.min(B, C) * (long) A);
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long numInRange = (((mid / B)) + ((mid / C)) - ((mid / lcm(B, C))));
            if (numInRange >= A) {
                ans = mid % mod;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);

    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

}

package dsa.combinatorics;

public class SortedPermRankWithRepeats {

    public static void main(String[] args) {
        SortedPermRankWithRepeats s = new SortedPermRankWithRepeats();
        System.out.println(s.findRank("QUEUE"));
    }

    public int findRank(String A) {
        int mod = 1000003;
        int n = A.length();
        int[] bag = new int[150];

        for (char c : A.toCharArray()) {
            bag[c]++;
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] % mod * i % mod) % mod;
        }

        // Calculating answer
        long res = 0;
        int currPos = 1;
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);

            long numerator = 0;
            long denominator = 1;
            for (int j = 0; j < 150; j++) {
                if (j < (int) ch) {
                    numerator += bag[j];
                }
                denominator = (denominator % mod * fact[bag[j]] % mod) % mod;
            }

            // (numerator * factorials[N - currPos] / denominator) % mod
            // Since mod is a prime number and length can not be equal to or greater than
            // mod.
            // Therefore, (numerator, mod) are coprimes
            // Apply fermat’s little thm for denominator
            long tempRes = res;
            res = (numerator % mod * fact[(n - currPos)] % mod) % mod;
            res = (res % mod * fastPower(denominator, mod - 2, mod));
            res = (res % mod + tempRes % mod) % mod;

            bag[(int) ch]--;
            currPos++;
        }

        return (int) ((res + 1 + mod) % mod);
    }

    public long fastPower(long a, long b, long m) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res % m * a % m) % m;
                b = b - 1;
            }

            a = (a % m * a % m) % m;
            b = b / 2;
        }

        return res;
    }

}

package dsa.strings;

public class PeriodOfString {

    public static void main(String[] args) {
        System.out.println(solve("abababababb"));
    }

    public static int solve(String A) {
        int[] z = zAlgo(A);
        for (int i = 1; i < A.length(); i++) {
            if (i + z[i] == A.length()) {
                return i;
            }
        }
        return A.length();

    }

    public static int[] zAlgo(String A) {
        int n = A.length();
        int[] z = new int[n];
        z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            int j, k;
            if (i > r) {
                j = i;
                k = 0;
                while (j < n && A.charAt(j) == A.charAt(k)) {
                    j++;
                    k++;
                }
                z[i] = k;
                l = i;
                r = i + k - 1;
            } else {
                if (z[i - l] < (r - i + 1)) {
                    z[i] = z[i - l];
                } else {
                    j = r + 1;
                    k = r - i + 1;
                    while (j < n && A.charAt(j) == A.charAt(k)) {
                        j++;
                        k++;
                    }
                    z[i] = k;
                    l = i;
                    r = i + k - 1;
                }
            }
        }
        return z;
    }

    public static int solve1(String A) {
        int n = A.length();
        if (n == 1)
            return 1;
        int[] Z = new int[n];
        Zstring(Z, A, n);
        for (int i = 1; i < n; i++) {
            if (Z[i] == n - i)
                return i;
        }
        return n;
    }

    // Z-String Algorithm
    static void Zstring(int[] Z, String A, int n) {
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            if (i > right) {
                left = right = i;
                while (right < n && A.charAt(right) == A.charAt(right - i))
                    right++;
                Z[i] = right - left;
                right--;
            } else {
                if (Z[i - left] < right - left + 1)
                    Z[i] = Z[i - left];
                else {
                    left = i;
                    while (right < n && A.charAt(right) == A.charAt(right - i))
                        right++;
                    Z[i] = right - left;
                    right--;
                }
            }
        }
    }

}

package dsa.patternmatching;

public class ClosestPalindrome {

    public static void main(String[] args) {
        System.out.println(solve("aba"));
    }

    public static String solve(String A) {

        int n = A.length();
        if (n == 1) {
            return "YES";
        }

        char[] aChar = A.toCharArray();
        int p1 = 0, p2 = n - 1;
        int mismatchCount = 0;
        while (p1 < p2) {
            if (aChar[p1] != aChar[p2]) {
                mismatchCount++;
            }
            if (mismatchCount > 1) {
                break;
            }
            p1++;
            p2--;
        }
        if ((p1 == p2) && mismatchCount == 0) {
            return "YES";
        }

        return mismatchCount == 1 ? "YES" : "NO";
    }

}

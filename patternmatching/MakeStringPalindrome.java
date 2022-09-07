package patternmatching;

public class MakeStringPalindrome {

    public static void main(String[] args) {
        System.out.println(solve("babc"));
    }

    public static int solve(String A) {
        int n = A.length();
        boolean palin = isPalindrome(A);
        if (palin) {
            return 0;
        }

        int count = 1;

        while (count < n - 1) {
            String temp = A.substring(0, n - count);
            palin = isPalindrome(temp);
            if (palin) {
                break;
            }
            count++;
        }

        return count;
    }

    public static boolean isPalindrome(String A) {
        int n = A.length();
        if (n == 1) {
            return true;
        }
        char[] aChar = A.toCharArray();
        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            if (aChar[p1] != aChar[p2]) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }

}

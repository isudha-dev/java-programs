package dsa.patternmatching;

public class MakeStringPalindrome {

    public static void main(String[] args) {
        System.out.println(constructLPS("qacqacaapaa"));
    }

    public static int bruteforce(String A) {
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

    public static int optimised(String A) {
        StringBuffer sb = new StringBuffer(A);
        String revA = sb.reverse().toString();

        String newS = A + "$" + revA;
        int lps[] = constructLPS(newS);
        int len = lps[lps.length - 1];

        return A.length() - len;
    }

    public static int[] constructLPS(String A) {
        int n = A.length();
        char[] aChar = A.toCharArray();
        int[] lps = new int[n];
        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            int x = lps[i - 1];
            while (aChar[i] != aChar[x]) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }

}

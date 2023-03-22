package dsa.strings;

public class CyclicPermutation {

    public static void main(String[] args) {
        System.out.println(solve("1101111111", "1101111111"));
    }

    // "1101111111", "1101111111" //1
    public static int solve(String A, String B) {
        String s = B + B;

        String newS = A + "$" + s;
        int lps[] = constructLPS(newS);
        int totalOcc = 0;
        for (int i : lps) {
            if (i == A.length()) {
                totalOcc++;
            }
        }
        if (A.equals(B)) {
            return totalOcc - 1;
        }
        return totalOcc;
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

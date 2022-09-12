package patternmatching;

public class CountA {

    public static void main(String[] args) {
        System.out.println(solve("qacqacaapaa"));
    }

    public static int solve(String A) {
        int n = A.length();
        char[] aChar = A.toCharArray();

        int[] lps = constructLPS(A);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (aChar[i] == 'a') {
                count += lps[i];
            }
        }

        return (count * (count + 1)) / 2;

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

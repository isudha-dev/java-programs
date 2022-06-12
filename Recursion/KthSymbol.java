package recursion;

public class KthSymbol {

    public static void main(String[] args) {
        System.out.println(solve(20, 61));
    }

    static int solve(int A, int B) {
        String str = "0";
        if (A == 1) {
            return 0;
        }
        while (A > 1) {
            str = replace(str);
            A--;
        }
        char[] chArr = str.toCharArray();
        return Integer.parseInt(Character.toString(chArr[B - 1]));
    }

    static String replace(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int i = Integer.parseInt(Character.toString(ch));
            sb.append(i ^ 0);
            sb.append(i ^ 1);
        }

        return sb.toString();
    }

    static int solve1(int A, int B) {
        return solveQ(A, B) ? 1 : 0;
    }

    static boolean solveQ(int n, int k) {

        if (n == 1 && k == 1)
            return false;

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid)
            return solveQ(n - 1, k);
        else
            return !solveQ(n - 1, k - mid);

    }

}
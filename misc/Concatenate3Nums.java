import java.util.Arrays;

public class Concatenate3Nums {

    public static void main(String[] args) {

        System.out.println(solve(75, 45, 48));

    }

    static int solve(int A, int B, int C) {
        int[] a = new int[] { A, B, C };
        Arrays.sort(a);
        return 10000 * a[0] + 100 * a[1] + a[2];
    }
}

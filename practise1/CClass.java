package practise1;

public class CClass {

    static boolean isPowerOf2(int n) {
        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    // counting all subsequences whose
    // product is power of 2.
    static int countSubsequence(int a[], int size) {
        int count = 0;
        for (int i = 0; i < size; i++)
            if (isPowerOf2(a[i]))
                count++;
        return (int) (Math.pow(2, count)) - 1;
    }

    // Driver
    public static void main(String args[]) {
        int a[] = { 1, 2, 3, 8, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
        System.out.println(countSubsequence(a, a.length));
        int b[] = { 3, 5, 9 };
        System.out.println(countSubsequence(b, b.length));
    }

}

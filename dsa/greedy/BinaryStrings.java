package dsa.greedy;

public class BinaryStrings {
    public static void main(String[] args) {
        BinaryStrings bs = new BinaryStrings();
        bs.solve1("00010110", 3);
    }

    public int solve(String A, int B) {
        int count0 = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            sb.append(A.charAt(i));
            if (A.charAt(i) == '0')
                count0++;
        }
        if (count0 == 0) {
            return 0;
        }
        if (A.length() == B) {
            return -1;
        }

        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            if (sb.charAt(i) == '0') {
                ans++;
                for (int j = i; j < i + B; j++) {
                    if (sb.charAt(j) == '0')
                        sb.replace(j, j + 1, "1");
                    else
                        sb.replace(j, j + 1, "0");
                }
            }

        }

        return ans;
    }

    public int solve1(String A, int B) {
        int ans = 0;
        boolean flip = false;
        int[] arr = new int[A.length()];

        for (int i = 0; i < A.length(); i++) {
            if (arr[i] == 1)
                flip = !flip;
            if ((A.charAt(i) == '0' && !flip) || (A.charAt(i) == '1' && flip)) {
                flip = !flip;
                ans++;
                if (i + B < A.length())
                    arr[i + B] = 1;
                if (i + B > A.length())
                    return -1;
            }
        }
        return ans;
    }
}

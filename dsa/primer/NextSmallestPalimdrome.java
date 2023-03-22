package dsa.primer;

public class NextSmallestPalimdrome {

    public static void main(String[] args) {

        System.out.println(solve("9"));
    }

    static String solve(String A) {

        int[] num = new int[A.length()];
        int i = 0;
        for (String s : A.split("")) {
            num[i] = Integer.parseInt(s);
            i++;
        }

        int[] pdNum = generateNextPalindrome(num);
        StringBuilder sb = new StringBuilder();

        for (int pn : pdNum) {
            sb.append(String.valueOf(pn));
        }

        return sb.toString();
    }

    static int[] generateNextPalindrome(int[] num) {
        int[] pdNum;
        if (isAll9(num)) {
            int len = num.length + 1;
            pdNum = new int[len];
            pdNum[0] = 1;
            pdNum[len - 1] = 1;
            for (int i = 1; i < len - 2; i++) {
                pdNum[i] = 0;
            }
        } else {

            pdNum = generateNextPalindromeForPdAndNonPd(num);
        }
        return pdNum;

    }

    static boolean isAll9(int[] num) {
        for (int n : num) {
            if (n != 9)
                return false;
        }
        return true;
    }

    static int[] generateNextPalindromeForPdAndNonPd(int[] num) {

        int n = num.length;
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        boolean copyingSufficient = true;

        // for pd i gets set to -1 and j gets set to n and it exits the loop
        // for non-pd loop exits when difits on both sides differ
        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        // for pd, this sets to false everytime because i becomes -1 in previous step
        // for non-pd, if any of left digit is smaller then it sets to false else true
        if (i < 0 || num[i] < num[j]) {
            copyingSufficient = false;
        }

        // copy left digit to right (will execute for all non-dsa.palindrome num)
        while (i >= 0) {
            num[j] = num[i];
            j++;
            i--;
        }

        // we get pd for all num[] from previous step here
        // now in next steps we increment middle digit and propogate carry (if any)
        // below steps will only execute for pd & for non-pd where just copying is not
        // sufficent

        if (!copyingSufficient) {
            int carry = 1;

            // if there are odd digits, increment the mid and save carry (if any)
            if (n % 2 == 1) {
                num[mid] += 1;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }

            i = mid - 1;
            j = (n % 2 == 0) ? mid : mid + 1;

            // if we have carry we need to propogate that to previous step and continue
            // at the same time we need to copy digits from left to right
            while (carry > 0 && i >= 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i]; // copy left to right
                i--;
                j++;
            }

        }

        return num;

    }

}

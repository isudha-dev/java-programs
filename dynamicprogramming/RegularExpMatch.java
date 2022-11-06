package dynamicprogramming;

public class RegularExpMatch {

    public static void main(String[] args) {
        RegularExpMatch re = new RegularExpMatch();
        re.isMatch("aaa", "a*");
    }

    public int isMatch(final String A, final String B) {

        boolean flag = true;
        int i = A.length() - 1, j = B.length() - 1;

        while (flag && i >= 0 && j >= 0) {
            if ((B.charAt(j) == '?') || (B.charAt(j) == A.charAt(i))) {
                i--;
                j--;
            } else if (B.charAt(j) == '*') {
                i--;
            } else {
                flag = false;
            }
        }

        return flag ? 1 : 0;
    }

}

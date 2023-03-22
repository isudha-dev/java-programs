package dsa.strings;

//given a substring, find if substring is a dsa.palindrome
public class SubstringPalin {
    public static void main(String[] args) {
        System.out.println(isPalin("anaycoana", 0, 8));

    }

    static boolean isPalin(String str, int start, int end) {

        char[] chStr = str.toCharArray();

        while (start < end) {
            if (chStr[start] != chStr[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}

package dsa.primer;

public class ReverseString {

    // Input: s = ['h','e','l','l','o']
    // Output: ['o','l','l','e','h']

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s);

    }

    static void reverseString(char[] s) {

        int i;
        char temp;
        int n = s.length;

        i = 0;
        int mid = i + (n - 1 - i) / 2;
        for (i = 0; i <= mid; i++) {
            temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }

    }
}

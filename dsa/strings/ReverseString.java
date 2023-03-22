package dsa.strings;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(solve("the sky is blue"));
    }

    static String solve(String A) {

        char[] ch = reverseStringRange(A, 0, A.length() - 1).toCharArray();
        String s = new String(ch);

        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = p1 + 1;

        while (p1 < ch.length) {
            if (ch[p1] == ' ') {
                p1++;
                p2++;
                continue;
            } else if (ch[p2] != ' ') {
                p2++;
            } else if (ch[p1] != ' ' && ch[p2] == ' ') {
                sb.append(reverseStringRange(s, p1, p2 - 1).substring(p1, p2));
                sb.append(" ");
                p1 = p2 + 1;
                p2 = p1 + 1;
            }

        }

        return sb.toString();

    }

    static String reverseStringRange(String str, int start, int end) {
        char[] ch = str.toCharArray();
        int i = start, j = end;
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }

}

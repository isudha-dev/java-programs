package strings;

public class ReversingPartOfStr {

    public static void main(String[] args) {
        System.out.println(reverseStr(new char[] { 'a', 'n', 'a', 'c', 'o', 'n', 'd', 'a' }, 0, 8));
    }

    static char[] reverseStr(char[] str, int start, int end) {
        int p1 = start;
        int p2 = end - 1;
        while (p1 < p2) {
            char temp = str[p1];
            str[p1] = str[p2];
            str[p2] = temp;
            p1++;
            p2--;
        }

        return str;

    }

}

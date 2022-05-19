package strings;

public class ReverseStatement {

    public static void main(String[] args) {
        System.out.println(reverseStmt(new char[] { 't', 'h', 'i', 's', ' ', 'i', 's', ' ', 's', 'u', 'd', 'h', 'a' }));
    }

    static char[] reverseStmt(char[] str) {
        ReversingPartOfStr.reverseStr(str, 0, str.length);
        int p1 = 0, p2 = 0;
        while (p1 < str.length) {
            while (str[p2] != ' ') {
                p2++;
                if (p2 == str.length) {
                    break;
                }
            }
            ReversingPartOfStr.reverseStr(str, p1, p2);
            p1 = p2 + 1;
            p2 = p1;

        }

        return str;

    }

}

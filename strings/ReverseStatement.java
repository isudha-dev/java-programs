package strings;

public class ReverseStatement {

    public static void main(String[] args) {
        String A = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";
        char[] ch = reverseStmt(A.toCharArray());
        String B = new String(ch).trim();
        System.out.println(B);
    }

    static char[] reverseStmt(char[] str) {
        ReversingPartOfStr.reverseStr(str, 0, str.length);
        int p1 = 0, p2 = 0;
        while (p1 < str.length) {
            if (str[p1] == ' ') {
                p1++;
                p2++;
                continue;
            }
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

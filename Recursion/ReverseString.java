package recursion;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();

        System.out.println(reverseStr(str, 0, str.length() - 1));
    }

    static String reverseStr(String str, int s, int e) {
        char[] c = str.toCharArray();
        if (s >= e) {
            return str;
        } else {
            char temp = c[s];
            c[s] = c[e];
            c[e] = temp;
            str = new String(c);
        }

        return reverseStr(str, ++s, --e);
    }

}

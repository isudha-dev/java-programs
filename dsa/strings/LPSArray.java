package dsa.strings;

import java.util.Arrays;

public class LPSArray {
    public static void main(String[] args) {
        String s = "acabbc";
        StringBuffer sb = new StringBuffer(s);
        String rev = sb.reverse().toString();

        int[] lps = constructLPS(s+"$"+rev);
        int len = lps[lps.length - 1];

        System.out.println( s.length() - len);
    }

    public static int[] constructLPS(String str){
        int n = str.length();
        int[] lps = new int[n];

        lps[0] = 0;

        for(int i = 1; i<n; i++){
            int x = lps[i-1];
            while (str.charAt(i) != str.charAt(x)){
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x-1];
            }
            lps[i] = x+1;
        }
        return lps;
    }
}

package dsa.patternmatching;

public class SmallestPrefixString {

    public static void main(String[] args) {
        System.out.println(smallestPrefix("acd", "bay"));
    }

    public static String smallestPrefix(String A, String B) {

        char[] aChar = A.toCharArray();
        char[] bChar = B.toCharArray();

        StringBuffer ans = new StringBuffer();

        ans.append(aChar[0]);
        int i = 1;
        while (i < aChar.length) {
            if (aChar[i] < bChar[0]) {
                ans.append(aChar[i]);
                i++;
            } else {
                break;
            }
        }
        ans.append(bChar[0]);

        return ans.toString();
    }

}
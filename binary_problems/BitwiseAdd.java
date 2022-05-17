package binary_problems;

import java.util.ArrayList;
import java.util.Collections;

public class BitwiseAdd {

    public static void main(String[] args) {
        System.out.println(bitwiseAdd("1110000000010110111010100100111", "101001"));
    }

    static String bitwiseAdd(String A, String B) {
        int sum = 0;
        int carry = 0;
        ArrayList<String> ans = new ArrayList<>();

        int i = A.length() - 1, j = B.length() - 1;
        String[] arrA = A.split("");
        String[] arrB = B.split("");

        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0 && j >= 0) {
                sum = (Integer.parseInt(arrA[i]) + Integer.parseInt(arrB[j]) + carry);
            } else if (i < 0 && j >= 0) {
                sum = (Integer.parseInt(arrB[j]) + carry);
            } else if (j < 0 && i >= 0) {
                sum = (Integer.parseInt(arrA[i]) + carry);
            } else {
                sum = carry;
            }
            carry = sum / 2;
            sum = sum % 2;
            i--;
            j--;
            ans.add(String.valueOf(sum));
        }

        Collections.reverse(ans);

        // String s = ans.stream().map(Object::toString).collect(Collectors.joining());

        String s = ans.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "");

        return s;
    }

}

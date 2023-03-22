package dsa.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNum {

    // https://www.scaler.com/academy/mentee-dashboard/class/25583/homework/problems/64?navref=cl_tt_nv
    public static void main(String[] args) {

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0 }));
        System.out.println(largestNumber(A));
    }

    static String largestNumber(final List<Integer> A) {

        List<Integer> B = new ArrayList<>(A);
        B.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String strA = a + "" + b;
                String strB = b + "" + a;
                return strB.compareTo(strA);

            }
        });

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < A.size(); i++) {
            str.append(B.get(i));
        }
        if (str.charAt(0) == '0') {
            return "0";
        }
        return str.toString();

    }

}

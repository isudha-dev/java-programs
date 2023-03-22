package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/29819/homework/problems/66/submissions
public class AddOneToNum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(new Integer[] { 0, 0, 9 }));
        System.out.println(plusOne(A));
    }

    static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        int carry = 0;
        int sum = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                carry += 1;
            }
            sum = A.get(i) + carry;
            carry = sum / 10;
            sum %= 10;
            A.set(i, sum);
        }

        if (carry != 0) {
            A.add(0, carry);
        }

        while (A.get(0) == 0) {
            A.remove(0);
        }

        return A;
    }
}

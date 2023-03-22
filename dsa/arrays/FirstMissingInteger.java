package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/29819/assignment/problems/65/submissions
public class FirstMissingInteger {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 3, 1, 2 }));
        System.out.println(firstMissingPositive(A));
    }

    static int firstMissingPositive(ArrayList<Integer> A) {
        int ans = 0;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            while (A.get(i) != i + 1 && A.get(i) >= 1 && A.get(i) <= n && A.get(i) != A.get(A.get(i) - 1)) {
                int value = A.get(i);
                int orgPosition = i;
                int newPosition = A.get(i) - 1;
                Integer temp = A.get(newPosition);
                A.set(newPosition, value);
                A.set(orgPosition, temp);
            }
        }

        for (int i = 0; i < n; i++) {
            if (A.get(i) != i + 1) {
                ans = i + 1;
                break;
            }
        }

        return ans == 0 ? n + 1 : ans;
    }

}

// Note: Not using recusive method here because that runs into stackoverflow for
// larger A size

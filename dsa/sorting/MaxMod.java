package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/29841/assignment/problems/1013?navref=cl_tt_nv
public class MaxMod {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 42, 494, 116, 845, 781, 38, 315,
                397, 405, 379, 427,
                835, 72, 926, 983, 508, 795, 590, 785, 475, 521, 81, 926, 835, 543, 539, 224, 775, 882, 825, 693, 594,
                391, 105, 973, 94, 445, 35, 709, 407, 789, 927, 672, 13, 107, 771, 875, 642, 903, 443, 31, 426, 769,
                551, 36, 83, 609, 542, 768, 188, 745, 380, 30, 238, 473, 865, 275, 332, 105, 874, 547, 318, 23, 790,
                767, 19, 643, 836, 126, 310, 460, 456, 466, 131, 376, 64, 19, 784, 594, 834, 257, 225, 956, 277, 488,
                34, 114, 35, 630, 112 }))));

    }

    static int solve(ArrayList<Integer> A) {
        int n = A.size();
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (first < A.get(i)) {
                second = first;
                first = A.get(i);
            } else if (second < A.get(i) && first != A.get(i)) {
                second = A.get(i);
            }
        }

        if (second != Integer.MIN_VALUE)
            return second;
        return 0;
    }
}

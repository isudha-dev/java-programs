package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {
    public static void main(String[] args) {
        System.out.println(sortColors(new ArrayList(Arrays.asList(new Integer[] { 0 }))));
    }

    static ArrayList<Integer> sortColors(ArrayList<Integer> A) {

        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0)
                cnt0++;
            if (A.get(i) == 1)
                cnt1++;
            if (A.get(i) == 2)
                cnt2++;
        }

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < cnt0; i++) {
            al.add(0);
        }
        for (int i = 0; i < cnt1; i++) {
            al.add(1);
        }
        for (int i = 0; i < cnt2; i++) {
            al.add(2);
        }
        return al;
    }

}

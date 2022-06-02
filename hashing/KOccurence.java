package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KOccurence {

    // https://www.scaler.com/academy/mentee-dashboard/class/25565/homework/problems/855?navref=cl_tt_lst_nm

    public static void main(String[] args) {
        System.out.println(getSum(3, 2, new ArrayList<>(Arrays.asList(new Integer[] { 0, 0, 1 }))));
    }

    static int getSum(int A, int B, ArrayList<Integer> C) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer i : C) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        double sum = 0;
        boolean found = false;
        for (Map.Entry<Integer, Integer> en : hm.entrySet()) {
            if (en.getValue() == B) {
                sum = (sum + en.getKey()) % (Math.pow(10, 9) + 7);
                found = true;
            }
        }

        return found ? (int) sum : -1;
    }

}

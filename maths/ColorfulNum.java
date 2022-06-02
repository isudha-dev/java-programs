package maths;

import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNum {

    // https://www.scaler.com/academy/mentee-dashboard/class/25565/homework/problems/275?navref=cl_tt_lst_nm
    public static void main(String[] args) {
        colorful(4561237);
    }

    static int colorful(int A) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (A > 0) {
            arr.add(A % 10);
            A = A / 10;
        }

        int n = arr.size();
        int subSeq = (n * (n + 1) / 2) - 1;
        int inc = 0;
        Integer prod = 1;
        HashSet<Integer> prodSet = new HashSet<>();

        for (int i = 1; i <= subSeq; i++) {
            for (int j = 0; j <= i; j++) {
                prod *= arr.get(j);
                if (prodSet.contains(prod)) {
                    return 0;
                }
            }
        }

        return 1;
    }

}

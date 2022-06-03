package maths;

import java.util.HashSet;

public class ColorfulNum {

    // https://www.scaler.com/academy/mentee-dashboard/class/25565/homework/problems/275?navref=cl_tt_lst_nm
    public static void main(String[] args) {
        colorful(4568237);
    }

    static int colorful(int A) {
        HashSet<Long> hs = new HashSet<>();

        while (A > 0) {
            Long prevPrd = 1L;
            Long B = (long) A;
            while (B > 0) {
                Long digit = B % 10;
                Long prod = digit * prevPrd;
                if (hs.contains(prod)) {
                    return 0;
                } else {
                    hs.add(prod);
                }
                prevPrd = prod;
                B = B / 10;
            }
            A = A / 10;
        }

        return 1;
    }

}

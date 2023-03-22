package dsa.strings;

public class CountOccurences {
    // https://www.scaler.com/academy/mentee-dashboard/class/25563/homework/problems/10748?navref=cl_tt_lst_nm
    public static void main(String[] args) {
        System.out.println(solve("a"));
    }

    static int solve(String A) {
        int idx = 0;
        int count = 0;

        while (idx < A.length() - 2) {
            if (A.substring(idx, idx + 3).equals("bob")) {
                count++;
                idx = idx + 2;
            } else {
                idx++;
            }
        }

        return count;
    }

}

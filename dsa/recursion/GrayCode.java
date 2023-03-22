package dsa.recursion;

import java.util.ArrayList;

public class GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(4));
    }

    static ArrayList<Integer> grayCode(int A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(1);
        return solve(res, A);
    }

    static ArrayList<Integer> solve(ArrayList<Integer> res, int A) {
        if (A == 1) {
            return res;
        }
        solve(res, A - 1);
        int n = res.size();
        for (int i = n - 1; i >= 0; i--) {
            res.add(res.get(i) + n);
        }
        return res;

    }

}

package Recursion;

import java.util.ArrayList;

public class GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

    static ArrayList<Integer> grayCode(int A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int p = 0;
        return solve(res, A, p);
    }

    static ArrayList<Integer> solve(ArrayList<Integer> res, int A, int element) {
        if (res.size() == (1 << A))
            return res;

        res.add((element ^ (element >> 1)));

        return solve(res, A, element + 1);
    }

    static ArrayList<Integer> grayCode1(int A) {
        int n = A;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int curSize = result.size();
            // push back all element in result in reverse order
            for (int j = curSize - 1; j >= 0; j--) {
                result.add(result.get(j) + (1 << i));
            }
        }
        return result;
    }

}

package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LetterPhone {

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        int[] nums = Arrays.stream(digits.split("")).mapToInt(Integer::parseInt).toArray();
        String[] strArr = map.get(nums[0]).split("");

        ans = new ArrayList<String>(Arrays.asList(strArr));

        for (int j = 1; j < nums.length; j++) {
            ArrayList<String> tmpList = findCombination(ans, map.get(nums[j]));
            ans.clear();
            ans.addAll(tmpList);
        }

        return ans;
    }

    static ArrayList<String> findCombination(ArrayList<String> strList, String s) {

        ArrayList<String> ans = new ArrayList<>();

        for (String s1 : strList) {
            for (String s2 : s.split("")) {
                ans.add(s1 + s2);
            }

        }

        return ans;
    }

}

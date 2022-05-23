package maths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElem {

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(3);
        System.out.println(majorityElementJ(lst));

    }

    static int majorityElement(final int[] A) {

        Map<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (hMap.containsKey(A[i])) {
                int freq = hMap.get(A[i]);
                hMap.put(A[i], freq + 1);
            } else {
                hMap.put(A[i], 1);
            }
        }

        int expectedFreq = A.length / 2;
        int ans = 0;

        for (Entry<Integer, Integer> entry : hMap.entrySet()) {
            if (entry.getValue() > expectedFreq) {
                ans = entry.getKey();
                break;
            }
        }

        return ans;
    }

    static int majorityElementList(final List<Integer> A) {
        Map<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            if (hMap.containsKey(A.get(i))) {
                int freq = hMap.get(A.get(i));
                hMap.put(A.get(i), freq + 1);
            } else {
                hMap.put(A.get(i), 1);
            }
        }

        int expectedFreq = A.size() / 2;
        int ans = 0;

        for (Entry<Integer, Integer> entry : hMap.entrySet()) {
            if (entry.getValue() > expectedFreq) {
                ans = entry.getKey();
                break;
            }
        }

        return ans;

    }

    static int majorityElementJ(final List<Integer> A) {
        if (A == null)
            return -1;
        int maj = A.get(0);
        int count = 1;
        int n = A.size();
        for (int i = 1; i < n; i++) {
            if (A.get(i) == maj) {
                count++;
            } else if (count == 1) {
                maj = A.get(i);
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) == maj)
                count++;
        }
        if (count > n / 2)
            return maj;
        return -1;
    }

}
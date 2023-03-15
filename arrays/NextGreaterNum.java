package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://leetcode.com/problems/next-greater-element-iii/
public class NextGreaterNum {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1999999999));
    }

    public static int nextGreaterElement(int n) {
        int temp = n;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp > 0) {
            arr.add(temp % 10);
            temp = temp / 10;
        }

        int p1 = 0, p2 = arr.size() - 1;
        while (p1 < p2) {
            int t = arr.get(p1);
            arr.set(p1, arr.get(p2));
            arr.set(p2, t);
            p1++;
            p2--;
        }

        int[] tempArr = new int[arr.size()];

        for (int i = arr.size() - 2; i >= 0; i--) {
            int j = i + 1;
            int index = -1;
            while (j <= arr.size() - 1) {
                if (arr.get(j) > arr.get(i)) {
                    index = j;
                }
                j++;
            }
            if (index != -1) {
                // swap
                int t = arr.get(i);
                arr.set(i, arr.get(index));
                arr.set(index, t);

                // sort elements from i+1 to arr.sie()-1
                tempArr = arr.stream().mapToInt(k -> k).toArray();
                Arrays.sort(tempArr, i + 1, arr.size());
                break;

            }
        }

        int result = IntStream.of(tempArr).reduce(0, (a, b) -> a * 10 + b);
        if (result <= 0 || result < n)
            return -1;
        else
            return result;
    }

}

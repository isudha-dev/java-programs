package twopointer;

import java.util.Arrays;
import java.util.HashSet;

public class PairWithGivenDiff {

    public static void main(String[] args) {
        PairWithGivenDiff pg = new PairWithGivenDiff();
        int[] A = new int[] { 1, 2 };
        System.out.println(pg.solve1(A, 0));

    }

    public int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int p1 = 0, p2 = 1;
        int count = 0;

        while (p2 < n) {
            if (Math.abs(A[p1] - A[p2]) < B) {
                p2++;
            } else if (Math.abs(A[p1] - A[p2]) > B) {
                p1++;
            } else {
                count++;
                p1++;
                p2++;
            }
        }

        return count;

    }

    public int solve1(int[] arr, int diff) {
        int p1 = 0;
        int p2 = 1;
        int arrayLength = arr.length;
        HashSet<String> set = new HashSet<>();
        Arrays.sort(arr);
        int numberOfPairs = 0;
        while (p2 < arrayLength) {
            if (diff == 0 && p1 < p2) {
                break;
            }
            int currentDiff = arr[p2] - arr[p1];
            if (currentDiff > diff) {
                // Reduce current diff
                p1++;
            } else if (currentDiff < diff) {
                // Increase current difference
                p2++;
            } else {
                // We got a pair
                String s = arr[p1] + " " + arr[p2];
                if (!set.contains(s)) {
                    set.add(s);
                    numberOfPairs++;
                }
                p1++;
                p2++;
            }
        }
        return numberOfPairs;
    }

}

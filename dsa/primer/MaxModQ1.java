package dsa.primer;

import java.util.Arrays;

public class MaxModQ1 {

  public static void main(String[] args) {

    System.out.println(solve(new int[] { 1, 3, 3, 3 }));
  }

  static int solve(int[] A) {
    Arrays.sort(A);
    int i = 2;
    int max = A[A.length - 1];
    int secondLargest = 0;

    while (i <= A.length) {
      secondLargest = A[A.length - i];
      i++;
      if (max != secondLargest) {
        break;
      }
    }
    return secondLargest % max;
  }
}
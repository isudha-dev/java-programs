package dsa.twopointer;

public class SortByColor {

    // 0 1 0 0 1 0
    // 0 0 2 1 1 2
    // 0 0 1 1 2 2
    public int[] sortColors(int[] A) {

        int red = 0, white = 0, blue = 0;

        for (int i : A) {
            if (i == 0)
                red++;
            else if (i == 1)
                white++;
            else
                blue++;
        }
        int[] ans = new int[A.length];
        int idx = 0;
        for (int x = 0; x < red; x++) {
            ans[idx] = 0;
            idx++;
        }
        for (int x = 0; x < white; x++) {
            ans[idx] = 1;
            idx++;
        }
        for (int x = 0; x < blue; x++) {
            ans[idx] = 2;
            idx++;
        }

        return ans;
    }

    public static int[] sortColorsSwap(int[] A) {
        int swapPos = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0 && swapPos < i) {
                int temp = A[swapPos];
                A[swapPos] = A[i];
                A[i] = temp;
                swapPos++;
            } else if (A[i] == 0 && swapPos == i) {
                swapPos++;
            }
        }
        swapPos = A.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 2 && swapPos > i) {
                int temp = A[swapPos];
                A[swapPos] = A[i];
                A[i] = temp;
                swapPos--;
            } else if (A[i] == 2 && swapPos == i) {
                swapPos--;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        sortColorsSwap(new int[] { 2, 1, 0, 2, 1, 2 });
    }
}

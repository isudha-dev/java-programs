package primer;

public class ArrayRearrangePivot {

    public static void main(String[] args) {
        System.out.println(rearrangePivot(new int[] { 11, 5, 12, 16, 3, 9, 17, 22, 2 }, 15));
    }

    static int[] rearrangePivot(int[] A, int pivot) {
        int p1 = 0, p2 = A.length - 1;
        boolean flagS = false, flagE = false;

        while (p1 < p2) {
            if (A[p1] < pivot && !flagS) {
                p1++;
            } else {
                flagS = true;
            }

            if (A[p2] > pivot && !flagE) {
                p2--;
            } else {
                flagE = true;
            }

            if (flagS && flagE) {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p1++;
                p2--;
                flagS = false;
                flagE = false;
            }
        }
        return A;
    }

}

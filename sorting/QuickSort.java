package sorting;

public class QuickSort {

    public static void main(String[] args) {

        int[] A = new int[] { 1, 2, 6, 5, 7, 9, 4 };
        System.out.println(solve(A));
    }

    static int[] solve(int[] A) {

        quickSort(A, 0, A.length - 1);
        return A;
    }

    static int partition(int[] A, int low, int high) {
        int pivot = A[high];

        int idx = 0;
        for (int i = low; i <= high; i++) {
            if (A[i] < pivot) {
                idx++;
            }
        }
        idx = low + idx;
        swap(A, idx, high);

        int p1 = low, p2 = high;
        while (p1 < idx && p2 > idx) {
            while (A[p1] < pivot && p1 < idx)
                p1++;
            while (A[p2] >= pivot && p2 > idx)
                p2--;
            swap(A, p1, p2);
        }

        return idx;
    }

    static void swap(int[] A, int p, int q) {
        int temp = A[p];
        A[p] = A[q];
        A[q] = temp;
    }

    static void quickSort(int[] A, int low, int high) {
        if (low >= high) {
            return;
        }
        int idx = partition(A, low, high);
        quickSort(A, low, idx - 1);
        quickSort(A, idx + 1, high);
    }

}

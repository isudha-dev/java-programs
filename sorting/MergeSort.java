package sorting;

public class MergeSort {

    public static void main(String[] args) {

        int[] A = new int[] { 8, 5, 7, 3, 4, 1, 2, 6 };
        mergeSort(A, 0, 7);
        System.out.println(A);
        // mergeSortedArray(new int[] { 1, 3, 4, 7, 2, 5, 6, 8 }, 0, 3, 7);
    }

    static void mergeSort(int[] A, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(A, low, mid);
        mergeSort(A, mid + 1, high);
        mergeSortedArray(A, low, mid, high);

    }

    static void mergeSortedArray(int[] A, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = A[low + i];
        }

        for (int i = 0; i < n2; i++) {
            r[i] = A[mid + 1 + i];
        }

        int p1 = 0, p2 = 0, idx = low;
        while (p1 < n1 && p2 < n2) {
            if (l[p1] < r[p2]) {
                A[idx] = l[p1];
                p1++;
            } else {
                A[idx] = r[p2];
                p2++;
            }
            idx++;
        }
        while (p1 < n1) {
            A[idx] = l[p1];
            p1++;
            idx++;
        }
        while (p2 < n2) {
            A[idx] = r[p2];
            idx++;
            p2++;
        }

    }

}

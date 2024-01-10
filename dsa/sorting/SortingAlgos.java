package dsa.sorting;

public class SortingAlgos {

    public static void main(String[] args) {
        int[] A = {17, 25, 31, 12, 4};
        insertionSort(A);
    }

    public static int[] insertionSort(int[] A){
        // pick element one-by-one and compare them with previous element until sorting condition is true
        int n = A.length;
        for(int i = 0; i<n; i++){
            int key = A[i];
            int j = i-1;
            while (j>=0 && A[j]>key){
                A[j+1]=A[j];
                j--;
            }
            A[j+1] = key;
        }
        return A;
    }

    public static int[] selectionSort(int[] A){

        return null;
    }

    public static int[] bubbleSort(int[] A){

        return null;
    }
}

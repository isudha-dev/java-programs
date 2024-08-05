package ProblemSolving.Arrays.Sorting;

import java.util.Arrays;

public class Problems {

    public static void main(String[] args) {
        int[] A = {5, 3, 9, 12, 2, 0, 6, 7};
//        insertionSort(new int[] {5, 3, 9, 12, 2, 0, 6, 7});
        quickSort(A);
        Arrays.stream(A).forEach(System.out::println);
    }

    public static void insertionSort(int[] A){
        int n = A.length;

        for(int i = 1; i<n; i++){
            int temp = A[i]; // select an element
            int j = i-1;
            while (j>=0 && A[j] > temp){ // for all the elements from lower indices which are bigger, swap them 1 position right
                A[j+1] = A[j]; // if a bigger element is found, swap its position one behind
                j--;
            }
            A[j+1] = temp; // put the element to correct position
        }
    }

    public static void quickSort(int[] A){
        quickSortHelper(A, 0, A.length-1);
    }

    public static int getPartition(int[] A, int low, int high){
        int pivot = A[low];
        int i = low, j = high;
        while (i<j){
            while (i <= high-1 && A[i] <= pivot){
                i++;
            }
            while (j >= low+1 && A[j] > pivot){
                j--;
            }
            if(i < j){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        A[low] = A[j];
        A[j] = pivot;

        return j;
    }

    public static void quickSortHelper(int[] A, int low, int high){
        if(low < high){
            int partitionIdx = getPartition(A, low, high);
            quickSortHelper(A, low, partitionIdx-1);
            quickSortHelper(A, partitionIdx+1, high );
        }
    }
}

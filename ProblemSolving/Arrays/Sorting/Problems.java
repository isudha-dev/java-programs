package ProblemSolving.Arrays.Sorting;

import java.util.Arrays;

public class Problems {

    public static void main(String[] args) {
        mergeTwoSortedArraysWithoutExtraSpace(new long[]{1,1,1,1} , new long[]{2,2,3,3,5});
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int count = 0;
        int l1 = a.length;
        int l2 = b.length;
        int p1 = 0, p2 = 0;
        while(count != l1 && p1<l1 && p2<l2){
            if(a[p1] <= b[p2]){
                count++;
                p1++;
            } else {
                count++;
                p2++;
            }
        }

        p2 = 0;
        while (p1 < l1){
            long temp = a[p1];
            a[p1] = b[p2];
            b[p2] = temp;
            p2++;
            p1++;
        }

        Arrays.sort(a);
        Arrays.sort(b);

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

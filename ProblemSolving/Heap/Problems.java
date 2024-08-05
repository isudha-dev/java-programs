package ProblemSolving.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problems {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = buildMinHeap(new ArrayList<>(List.of(12, 16, 14, 9, 10, 2, 7, 11, 1, 4, 5, 0, 1, 4, 3)));
        arrayList.forEach(i -> System.out.print(i+", "));
        System.out.println();
        // 0, 1, 1, 9, 4, 2, 3, 11, 16, 10, 5, 12, 14, 4, 7

        insert(arrayList, 3);
        System.out.println("After inserting 3");
        arrayList.forEach(i -> System.out.print(i+", "));
        System.out.println();
        // 0, 1, 1, 3, 4, 2, 3, 9, 16, 10, 5, 12, 14, 4, 7, 11

        heapSort(arrayList);
        System.out.println("After sorting");
        arrayList.forEach(i -> System.out.print(i+", "));
        System.out.println();
        // 0, 1, 1, 2, 3, 3, 4, 4, 5, 7, 9, 10, 11, 12, 14, 16


    }

    // build a min heap from given array
    public static ArrayList<Integer> buildMinHeap(ArrayList<Integer> arr){
        int n = arr.size();

        for (int i = n/2-1; i >= 0; i--) {
            percolateDownAll(arr, i, n);
        }

        return arr;
    }

    private static void percolateDownAll(ArrayList<Integer> arr, int i, int n) {
        // constructs min heap
        int minimum = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && arr.get(minimum) > arr.get(left))
            minimum = left;

        if(right < n && arr.get(minimum) > arr.get(right))
            minimum = right;

        if(minimum != i){
            int swap = arr.get(i);
            arr.set(i, arr.get(minimum));
            arr.set(minimum, swap);

            percolateDownAll(arr, minimum, n);
        }

    }

    private static void percolateUpAll(ArrayList<Integer> arr, int i, int n) {
        // constructs max heap
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && arr.get(largest) < arr.get(left))
            largest = left;

        if(right < n && arr.get(largest) < arr.get(right))
            largest = right;

        if(largest != i){
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            percolateUpAll(arr, largest, n);
        }

    }

    public static void heapSort(ArrayList<Integer> arrayList) {
        int n = arrayList.size();

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            percolateUpAll(arrayList, i, n);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arrayList.get(0);
            arrayList.set(0, arrayList.get(i));
            arrayList.set(i, temp);

            // Call max heapify on the reduced heap
            percolateUpAll(arrayList, 0, i);
        }
    }

    public static void insert(ArrayList<Integer> arrayList, int num){
        // insert at end
        // percolate up

        arrayList.add(num);
        int n = arrayList.size();
        percolateUp(arrayList, arrayList.size()-1, n);

    }
    private static void percolateUp(ArrayList<Integer> arrayList, int i, int size) {
        int minimum = i;
        int parent = (i-1)/2;

        while (arrayList.get(parent) > arrayList.get(minimum)){
            int swap = arrayList.get(parent);
            arrayList.set(parent, arrayList.get(minimum));
            arrayList.set(minimum, swap);

            minimum = parent;
            parent = (minimum-1)/2;
        }

    }

}

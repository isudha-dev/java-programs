package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class RadixSort {
    public static void main(String[] args) {
        int[] A = {456, 876, 123, 53, 825, 450, 569, 964, 364, 678, 739};
        radixSort(A);
        Arrays.stream(A).forEach(i -> System.out.print(i+ " "));
    }

    static int[] radixSort(int[] A){
        OptionalInt max = Arrays.stream(A).reduce(Integer::max);
        double log10 = Math.log10(max.getAsInt());
        int itr = (int) (Math.floor(log10)+1);
        for(int i = 0; i<itr; i++){
            bucketSort(A, i);
        }
        return A;
    }

    static int[] bucketSort(int[] A, int d){
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for(int i= 0; i<10; i++){
            bucket.add(new ArrayList<>());
        }
        for(int i: A){
            // get the number at 'd' digit
            int pow = (int) Math.pow(10,d);
            int digit = (i/pow) % 10;
            bucket.get(digit).add(i);
        }
        int idx = 0;
        for(ArrayList<Integer> eachBucket: bucket){
            for(int i: eachBucket){
                A[idx] = i;
                idx++;
            }
        }
        return A;
    }
}

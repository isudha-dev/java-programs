package interview.interview_bidgely;

import java.util.ArrayList;
import java.util.Arrays;

public class SortAndRemoveDuplicate {
    /*
    array elements
    7, 6, 7, 9, 1, 2, 2, 3, 4, 5, 5 ,6, 8
    sort and remove duplicates
    1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9

     */

    public static void main(String[] args) {
        int[] arr = new int[] {7, 6, 7, 9, 1, 1, 2, 2, 3, 4, 5, 5 ,6, 8, 7, 7, 6, 6, 9, 1, 2, 2};
        Arrays.sort(arr);
        // 1, 1, 1, 1, 2
        ArrayList<Integer> arrList = new ArrayList<>();

        int i = 1;

        while(i < arr.length){
            while (i < arr.length && arr[i] == arr[i-1]){
                i++;
            }
            arrList.add(arr[i-1]);
            i++;
        }
        System.out.println(arrList);

    }

}

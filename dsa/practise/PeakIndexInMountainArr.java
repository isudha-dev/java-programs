package dsa.practise;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/
public class PeakIndexInMountainArr {

    public static int peakIndexInMountainArray(int[] arr) {

        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                maxIndex = i;
                max = arr[i];
            }
        }

        boolean check = true;
        for(int i = maxIndex - 1; i >=0 ; i--) {
            if(max < arr[i]){
                check = false;
                break;
            }
        }

        for(int i = maxIndex + 1; i < arr.length; i++) {
            if(max < arr[i]) {
                 check = false;
                 break;
            }
        }

        if (check) return maxIndex;
        return -1;

    }

    public static int peakIndexInMountainArray1(int[] arr) {

        int i = 0;
        while (i < arr.length && arr[i+1] > arr[i]) {
            i++;
        }
        return i;

    }

    public static void main(String[] args) {
        peakIndexInMountainArray1(new int[] {3,4,5,1});
    }
}

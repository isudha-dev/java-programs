package dsa.practise;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 1 && nums[0] == target){
            return 0;
        }

        int index = -1;
        for(int i = 1; i <= len - 1; i++){
            if(nums[i] < nums[i-1]){
                index = i;
                break;
            }
        }

        int targetIndex = -1;
        if(index == -1){
            targetIndex = binarySearch(nums, target, 0, len-1);
            return targetIndex;
        }
        if(nums[index] == target){
            return index;
        }


        targetIndex = binarySearch(nums, target, 0, index-1);
        if(targetIndex == -1){
            targetIndex = binarySearch(nums, target, index + 1, len - 1);
        }

        return targetIndex;
    }

    public static int binarySearch(int[] nums, int target, int start, int end){
        if(start > end){
            return -1;
        }
        while (start <= end){
            int mid = (start+end) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {3,5,1}, 1));
    }
}

package dsa.binaryproblems;

public class BinarySearchLC {

    public static void main(String[] args) {
        search(new int[] {5}, 5);
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int mid;

        while (start<=end){
            mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid-1;
            } else if (nums[mid] < target){
                start = start+1;
            }
        }

        return -1;
    }
}

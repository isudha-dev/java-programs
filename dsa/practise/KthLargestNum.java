package dsa.practise;

public class KthLargestNum {

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length-1;
        k = n - k + 1;

        return quickSelect(nums, 0, n, k);
    }

    public static int correctPartition(int[] nums, int low, int high){
        int n = nums.length;
        int pivot = nums[high];
        int minCount = 0;

        // find count of elems smaller than pivot
        for (int i = low; i < high; i++){
            if(nums[i] <= pivot){
                minCount++;
            }
        }

        int newIndex = minCount+low;
        if(high == newIndex){
            return high;
        }

        // swap elems at nums[minCount+low], pivot
        nums = swap(nums, newIndex, high);

        int p1 = low, p2 = high;
        while (p1<newIndex && p2>newIndex){
            while (nums[p1] < pivot) p1++;
            while (nums[p2] > pivot) p2--;

            nums = swap(nums, p1, p2);
        }
        return newIndex;
    }

    public static int quickSelect(int nums[], int low, int high, int k){
        int ind = correctPartition(nums, low, high);
        if(ind == k) return nums[ind];
        if(ind < k) return quickSelect(nums, ind+1, high, k);
        else return quickSelect(nums, low, ind-1, k);
    }

    public static int[] swap( int[] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,3,3,3,4,3,3,3,3}, 1));
    }

    //failing for 3,3,3,3,4,3,3,3,3

}

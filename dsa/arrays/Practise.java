package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practise {

    public static void main(String[] args) {
//        System.out.println(goodPair(new int[] {1,2,3,4}, 7));
//        System.out.println(pickFromBothSides(new int[] {2, 3, -1, 4, 2, 1}, 4));
//        System.out.println(countingSubarray(242, new int[] {15,8,16}));
//        System.out.println(alternatingSubarray(new int[] {0,0,0,1,0,0,0,1,0,1,1}, 1));
        System.out.println(longestConsecutive1("11010110000000000"));
    }

    static int longestConsecutive1(String A) {
        char[] chArr = A.toCharArray();
        int n = chArr.length;
        int count1=0, count0=0;
        int maxLen = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++) {
            if (chArr[i] == '0')
                count0++;
            else
                count1++;
        }
        if(count1 == n){
            return n;
        }
        if(count0 == n){
            return 0;
        }

        for(int i = 0; i<n; i++){
            if(chArr[i] == '0') {
                int l = i - 1;
                int leftLen = 0;
                while (l >= 0 && chArr[l] == '1') {
                    leftLen++;
                    l--;
                }
                int r = i + 1;
                int rightLen = 0;
                while (r < n && chArr[r] == '1') {
                    rightLen++;
                    r++;
                }
                if(count1 > leftLen+rightLen)
                    maxLen = Math.max(maxLen, leftLen + rightLen + 1);
                else
                    maxLen = Math.max(maxLen, leftLen+rightLen);
            }
        }

        return maxLen;
    }

    static int[] alternatingSubarray(int[] A, int B){
        int n = A.length;
        int subarraySize = 2*B+1;
        int totalSubarrays = n- subarraySize+1;
        ArrayList<Integer> ansList = new ArrayList<>();

        for(int i = 0; i<totalSubarrays; i++){
            int prev = -1, flag = 1;
            for(int j = i; j<subarraySize+i; j++){
                if(A[j] == prev){
                    flag = 0;
                    break;
                }
                prev = A[j];
            }
            if(flag == 1){
                ansList.add(i+B);
            }
        }
        int[] ans = new int[ansList.size()];
        int idx = 0;
        for (int i: ansList){
            ans[idx] = i;
            idx++;
        }

        return ans;
    }
    static public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = nums[0];
        rightMin[n-1] = nums[n-1];

        for(int i = 1; i<n; i++){
            if(nums[i-1] < leftMin[i-1])
                leftMin[i] = nums[i-1];
            else
                leftMin[i] = leftMin[i-1];
        }

        for(int i  = n-2; i>=0; i--){
            if(nums[i+1] < rightMin[i+1])
                rightMin[i] = nums[i+1];
            else
                rightMin[i] = rightMin[i+1];
        }

        int currSum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i<n-1; i++){
            if(leftMin[i] < nums[i] && nums[i] > rightMin[i]){
                currSum = leftMin[i]+nums[i]+rightMin[i];
                minSum = Math.min(minSum, currSum);
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;

    }
    static int maxSubarray(int A, int B, int[] C) {
        int currSum = 0;
        int n = C.length;
        int p1 = 0, p2 = 0;
        int maxSum = Integer.MIN_VALUE;

        while(p2<n){
            currSum += C[p2];
            if(currSum > B){
                while (p1 < p2 && currSum > B){
                    currSum -= C[p1];
                    p1++;
                }
            }
            if(currSum == B){
                return currSum;
            }
            maxSum = Math.max(currSum, maxSum);

            p2++;
        }

        return maxSum > B ? 0 : maxSum;
    }

    static String solve(int[] A) {
        int n = A.length;
        if((A.length & 1) != 0){
            return "NO";
        }
        if((A[0] & 1) != 0 && (A[n-1] & 1) != 0){
            return "NO";
        }
        return "YES";
    }

    static int amazingSubarray(String A){
        int count = 0;
        String regex = "[aeiouAEIOU]";
        String[] sArr = A.split("");
        int n = A.length();
        for(int i = 0; i < sArr.length; i++){
            String s = sArr[i];
            if(s.matches(regex)){
                count =  count + (n-i);
            }
        }
        return count%10003;
    }

    static int pickFromBothSides(int[] A, int B){
        int n = A.length;
        long[] psArr = ps(A);
        long maxSum = Integer.MIN_VALUE; // for left 0, right B

        for(int i = 0; i<=B; i++){
            int left = i;
            int right = B-i;
            long sumL, sumR;
            if(left == 0)
                sumL = 0;
            else
                sumL = psArr[left-1];

            if(right == 0)
                sumR = 0;
            else
                sumR = psArr[n-1]-psArr[n-right-1];
            maxSum = Math.max(maxSum, sumL+sumR);
        }
        return (int) maxSum;
    }

    static int specialIndex(int[] nums){
        int n = nums.length;
        int[] pseArr = pse(nums);
        int[] psoArr = pso(nums);
        int ans = 0;

        // for index 0
        if(pseArr[n-1]-pseArr[0] == psoArr[n-1]-psoArr[0]){
            ans++;
        }

        for(int i=1; i<n; i++){
            // sum of even indices = left->sumE(0,i-1) + right->sum0(i+1,n-1)
            int sumE = pseArr[i-1]+(psoArr[n-1] -psoArr[i]);

            // sum of odd indices = left->sumO(0,i-1) + right->sumE(i+1,n-1)
            int sumO = psoArr[i-1]+(pseArr[n-1] -pseArr[i]);

            if(sumE == sumO){
                ans++;
            }
        }

        return ans;
    }

    static long[] ps(int[] arr){
        int n = arr.length;
        long ans[] = new long[n];
        ans[0] = arr[0];

        for(int i = 1; i<n; i++){
            ans[i] = ans[i-1]+ (long) arr[i];
        }
        return ans;
    }

    static int[] pse(int[] arr){
        int n = arr.length;
        int ans[] = new int[n];
        ans[0] = 0;

        for(int i = 1; i<n; i++){
            if((i&1) != 1){ // odd
                ans[i] = ans[i-1];
            } else {
                ans[i] = ans[i-1]+arr[i];
            }
        }
        return ans;
    }

    static int[] pso(int[] arr){
        int n = arr.length;
        int ans[] = new int[n];
        ans[0] = arr[0];

        for(int i = 1; i<n; i++){
            if((i&1) == 1){ // even
                ans[i] = ans[i-1];
            } else {
                ans[i] = ans[i-1]+arr[i];
            }
        }
        return ans;
    }

    public static int[] rotateArrayBTimes(int[] arr, int B){
        // reverse entire array (n/2)
        int n = arr.length;
        B = B%n;
        int p1 = 0, p2 = n-1;
        rotateArr(arr, p1, p2);

        p1 = 0;
        p2 = B-1;
        rotateArr(arr, p1, p2);

        p1 = B;
        p2 = n-1;
        rotateArr(arr, p1, p2);

        return arr;
    }

    static int[] rotateArr(int[] arr, int p1, int p2){
        while (p1<p2){
            int t = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = t;
        }
        return arr;
    }

    static int[] goodPair(int[] A, int B){
        Arrays.sort(A);
        int n = A.length;
        for(int i = 0; i < n; i++){
            int bsResult = binarySearch(A, i+1, n-1, B-A[i]);
            if(bsResult != -1){
                System.out.println(A[i]+" "+A[bsResult]);
                return new int[] {i, bsResult};
            }
        }
       return null;
    }

    static int binarySearch(int[] A, int start, int end, int target){
        while(start <= end){
            int mid = (start+end)/2;
            int num = A[mid];
            if(num == target){
                return mid;
            } else if(num<target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

}

/*
1.Given a binary string S, the task is to find the longest subsequence with that has equal number of 0s and 1s and all the 0s are present before all the 1s.

nput: S = “0011001111”
Output: 8
Explanation: By removing the 3rd and 4th characters, the string becomes 00001111.
This is the longest possible subsequence following the given conditions.

Input: S = “11001”
Output: 2
Explanation: The longest possible subsequence satisfying the conditions is “01”

Input: S = “111100”
Output: 0

 */

public class Test {

    public static void main(String[] args) {
        int arr[] = new int[] {};
        int idx = rotationIdx(arr);
        int ans = binSearchH(arr, idx, 9);
        System.out.println(ans);
    }

    static int longestSub(int[] arr){
        int n = arr.length;
        int maxCount = Integer.MIN_VALUE;
        int lastOccIndex = -1;
        boolean foundOne = false;
        int localCount = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == 1 && !foundOne){
                foundOne = true;
                localCount++;
                if(localCount > maxCount){
                    maxCount = localCount;
                    lastOccIndex = i;
                }
                continue;
            }
            if(arr[i] == 0){
                foundOne = false;
                localCount = 0;
                continue;
            }
            if(foundOne && arr[i]==1){
                localCount++;
                if(localCount > maxCount){
                    maxCount = localCount;
                    lastOccIndex = i;
                }
            }
        }

        int countZero = 0;
        for(int i = 0; i<lastOccIndex;i++){
            if (arr[i] == 0){
                countZero++;
            }
        }

        if(maxCount > countZero){
            return countZero*2;
        } else {
            return maxCount*2;
        }

    }

    static int rotationIdx(int[] arr){
        //  9 10 11 12 13 14 1 2 3 4
        int n = arr.length;

        int s = 0;
        int e = arr.length - 1;
        while (s < e){
            int mid = (s+e)/2;
            if(arr[mid] > arr[n-1]){
                s = mid+1;
            } else {
                e = mid - 1;
            }
        }

        return e;
    }

    static int binarySearch(int arr[], int s, int e, int k){
        while (s <= e){
            int mid = (s+e)/2;
            if(arr[mid] == k){
                return mid;
            } else if(k < arr[mid]) {
                e = mid - 1;
            } else {
                s = mid+1;
            }
        }
        return -1;
    }
    static int binSearchH(int arr[], int idx, int k){
        int n = arr.length;
        int ans ;
        if(k < arr[0] && k < arr[idx]){
            ans = binarySearch(arr, idx+1, n-1, k);
        } else {
            ans = binarySearch(arr, 0, idx, k);
        }
        return ans;
    }










}

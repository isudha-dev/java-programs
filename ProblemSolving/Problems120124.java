package ProblemSolving;

import java.util.Arrays;

public class Problems120124 {
    public static void main(String[] args) {
//        System.out.println(reversePair(new int[] {2000000000,2000000000,-2000000000}, 0, 2)); // 18, 8, 6, 4, 6, 16, 49 // 4,
//        System.out.println(sumTheDiff(new int[] {
//        7,8,6,4,6,7,3,10,2,3,8,1,10,4,7,1,7,3,7,2,9,8,10,3,1,3,4,8,6,10,3,3,9,10,8,4,7,2,3,10,4,2,10,5,8,9,5,6,1,4,7,2,1,7,4,3,1,7,2,6,6,5,8,7,6,7,10,4,8,5,6,3,6,5,8,5,5,4,1,8,9,7,9,9,5,4,2,5,10,3,1,7,9,10,3,7,7,5,10,6,1,5,9,8,2,8,3,8,3,3,7,2,1,7,2,6,10,5,10,1,10,2,8,8,2,2,6,10,8,8,7,8,4,7,6,7,4,10,5,9,2,3,10,4,10,1,9,9,6,1,10,7,4,9,6,7,2,2,6,10,9,5,9,2,1,4,1,5,5,5,5,8,7,4,2,8,6,10,7,3,2,8,9,6,8,5,2,9,6,10,8,6,4,9,9,4,2,9,10,7,5,4,4,4,9,7,1,5,9,9,9,10,8,8,7,5,4,1,4,1,10,3,6,5,1,6,10,5,7,10,3,3,5,8,8,6,5,9,2,3,9,10,4,7,9,1,3,2,1,6,2,2,1,9,6,1,7,5,7,3,6,9,7,3,9,5,8,3,5,1,7,3,10,10,1,9,2,4,2,2,1,4,5,1,4,10,2,10,7,10,4,4,9,1,6,7,7,5,1,1,5,7,3,7,8,6,7,10,9,8,3,9,3,10,10,7,1,3,8,7,2,4,3,2,6,10,10,2,5,10,2,1,8,6,9,8,1,5,9,1,5,3,10,7,2,1,5,3,3,3,1,6,6,3,10,1,3,9,4,9,1,5,1,10,2,10,7,3,6,5,5,10,10,4,7,1,6,1,3,10,5,4,6,2,8,5,4,2,5,7,10,5,3,3,7,5,2,3,9,9,10,3,9,9,9,7,9,4,9,4,4,4,9,1,5,8,7,9,10,1,7,9,8,10,1,4,4,4,8,4,3,7,6,3,7,6,9,8,10,7,1,5,2,1,5,9,8,1,9,7,3,5,8,10,4,10,3,9,4,1,2,8,9,10,2,6,5,10,3,6,8,5,10,10,5,6,10,4,6,8,1,9,2,10,10,8,9,3,6,4,5,10,1,3,1,2,10,7,3,2,3,1,8,4,2,2,10,1,6,7,8,8,5,1,7,5,8,5,9,6,9,3,7,1,7,7,5,7,3,9,10,7,1,8,1,2,1,2,4,8,8,3,7,5,6,3,1,3,10,1,10,10,5,6,2,1,4,8,9,9,7,1,5,7,8,7,1,10,8,6,10,8,9,6,4,4,9,4,8,10,4,8,9,8,5,2,10,1,10,9,9,6,9,5,4,8,2,4,9,1,10,8,10,10,4,3,5,4,8,2,3,3,1,3,2,8,6,2,8,5,2,8,2,2,2,8,1,5,1,9,6,2,7,7,3,2,10,7,5,9,1,9,2,1,3,3,10,8,6,7,5,7,4,8,10,8,5,10,2,8,1,7,1,9,6,4,10,5,2,6,5,2,6,6,5,10,9,4,9,6,3,3,3,8,1,4,5,7,4,7,4,4,5,5,4,10,8,3,6,9,10,1,3,5,8,7,6,8,2,4,4,4,9,6,2,1,9,8,7,4,6,1,9,1,5,2,2,4,6,10,4,5,2,6,1,9,4,6,7,6,10,10,1,8,7,4,8,7,2,6,1,7,6,1,9,2,3,3,7,10,2,1,5,3,8,5,1,4,3,9,1,4,8,1,1,4,5,10,3,8,5,3,6,3,5,5,4,9,7,1,9,10,3,3,4,2,9,4,5,3,3,5,6,2,8,6,8,2,7,10,9,2,4,4,4,8,10,9,7,8,1,5,9,5,9,2,7,9,6,3,2,10,10,7,1,7,5,10,10,1,9,10,4,2,5,9,10,7,8,8,4,8,2,3,3,2,6,1,10,1,5,1,2,4,8,5,2,2,4,1,4,3,2,8,6,7,6,5,3,3,2,8,3}));
//        quickStartMain(new int[] {1, 4, 10, 2, 1, 5});

        findCount(new int[] {7,4 ,7 ,7 ,7 ,8 ,10, 10}, 3);
    }

    public static int findCount(final int[] A, int B) {

        int n = A.length;
        int l = 0;
        int r = n-1;

        // find left most index
        int lIdx = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == B){
                lIdx = mid;
                r = mid-1;
            } else if(A[mid] < B){
                l = mid+1;
            } else {
                r = mid - 1;
            }
        }

        // find right most index
        int rIdx = -1;
        l = 0; r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == B){
                rIdx = mid;
                l = mid+1;
            } else if(A[mid] < B){
                l = mid+1;
            } else {
                r = mid - 1;
            }
        }

        return rIdx-lIdx+1;
    }
    public static int[] quickStartMain(int[] A) {
        int n = A.length;
        for(int i = 0; i<n; i++){
            quickSort(A, n-1-i);
        }
        return A;
    }

    static void quickSort(int[] A, int pivotIdx){
        int n = A.length;
        int p1 = 0, p2 = n-1;

        while(p1<pivotIdx && p2>pivotIdx){
            while(p1<pivotIdx && A[p1] < A[pivotIdx])
                p1++;
            if(p1 == pivotIdx){
                break;
            }
            while(p2>pivotIdx && A[p2] > A[pivotIdx])
                p2--;
            if(p2 == pivotIdx){
                break;
            }

            int temp = A[p1];
            A[p1] = A[p2];
            A[p2] = temp;
        }
    }
    public static int sumTheDiff(int[] A) {
        // sort the array
        Arrays.sort(A);
        int Mod = 1000 * 1000 * 1000 + 7;
        long minus = 0, plus = 0;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            // summation of smallest numbers over all subsequences
            minus += (val * fastExponentWithMod(2, A.length - 1 - i, Mod)) % Mod;
            minus %= Mod;
            // summation of largest numbers over all subsequences
            plus += (val * fastExponentWithMod(2, i, Mod)) % Mod;
            plus %= Mod;
        }
        return (int)((plus - minus + Mod) % Mod);
    }

    public static long fastExponentWithMod(int a, int n, int mod){
        if(n == 0 || a == 1)
            return 1;
        if(n == 1)
            return a;
        long p = fastExponentWithMod(a, n/2, mod);
        long res = (p*p)%mod;
        if(n%2 == 0)
            return res;
        else
            return (res*a)%mod;
    }

    public static long pow(long x, int y, int k) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }

    public static int reversePair(int[] A, int low, int high) {
        if(low>=high){
            return 0;
        }
        int mid = (low+high)/2;
        int l = reversePair(A, low, mid);
        int r = reversePair(A, mid+1, high);

        int[] lSorted = Arrays.stream(Arrays.copyOfRange(A,low,mid+1)).sorted().toArray();
        int[] rSorted = Arrays.stream(Arrays.copyOfRange(A,mid+1,high+1)).sorted().toArray();

        int p1 = 0, p2 = 0;
        long totalCount = 0;
        while (p1<lSorted.length && p2<rSorted.length){
            long mul = (long) 2*rSorted[p2];
            while (p1<lSorted.length && lSorted[p1] <= mul){
                p1++;
            }
            p2++;
            totalCount += (lSorted.length-p1);
        }
        return (int) (totalCount+l+r);
    }

    public static int[][] bClosestPointToOrigin(int[][] A, int B) {
        if (A.length == 0 || A.length == 1) {
            return A;
        }
        Arrays.sort(A, (int[] p, int[] q) -> {
                    int d1 = p[0] * p[0] + p[1] * p[1];
                    int d2 = q[0] * q[0] + q[1] * q[1];
                    return d1-d2;
                }
        );
        return Arrays.copyOfRange(A, 0, B);
    }

}

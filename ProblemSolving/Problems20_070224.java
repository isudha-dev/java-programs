package ProblemSolving;

import java.util.*;

public class Problems20_070224 {
    public static void main(String[] args) {
//        singleNumber(new int[] {1, 2, 4, 3, 3, 2, 2, 3, 1, 1});
                //890, 992, 172, 479, 973, 901, 417, 215, 901, 283, 788, 102, 726, 609, 379, 587, 630, 283, 10, 707, 203, 417, 382, 601, 713, 290, 489, 374, 203, 680, 108, 463, 290, 290, 382, 886, 584, 406, 809, 601, 176, 11, 554, 801, 166, 303, 308, 319, 172, 619, 400, 885, 203, 463, 303, 303, 885, 308, 460, 283, 406, 64, 584, 973, 572, 194, 383, 630, 395, 901, 992, 973, 938, 609, 938, 382, 169, 707, 680, 965, 726, 726, 890, 383, 172, 102, 10, 308, 10, 102, 587, 809, 460, 379, 713, 890, 463, 108, 108, 811, 176, 169, 313, 886, 400, 319, 22, 885, 572, 64, 120, 619, 313, 3, 460, 713, 811, 965, 479, 3, 247, 886, 120, 707, 120, 176, 374, 609, 395, 811, 406, 809, 801, 554, 3, 194, 11, 587, 169, 215, 313, 319, 554, 379, 788, 194, 630, 601, 965, 417, 788, 479, 64, 22, 22, 489, 166, 938, 66, 801, 374, 66, 619, 489, 215, 584, 383, 66, 680, 395, 400, 166, 572, 11, 992});

//        int A = 17; // Replace with your positive integer A
//        countTotalSetBits(17);
//        System.out.println(binarySearchRotated(new int[] {1, 7, 67, 133, 178}, 67));
//        System.out.println(findMedianSortedArrays(List.of( -50, -41, -40, -19, 5, 21, 28), List.of(-50, -21, -10)));
//        System.out.println(findMedianSortedArrays2(List.of(1,4,4,5, 6,7,8,9,15), List.of(2,3,6, 8,8,12,16))); // 1 2 3 4 4 5 6 6 7 8 8 8 9 12 15 16
//        System.out.println(sqrt(2048));
//        System.out.println(rotatedSortedArraySearch(List.of(1, 7, 67, 133, 178), 1));
//        System.out.println(specialInteger(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 10));
//        System.out.println(athMagicalNum(426344489, 36067, 29025));
//        System.out.println(kthPrice(List.of(8,16,80,55,32,8,38,40,65,18,15,45,50,38,54,52,23,74,81,42,28,16,
//                66,35,91,36,44,9,85,58,59,49,75,20,87,60,17,11,39,62,20,17,46,26,81,92), 9));
//        System.out.println(numberGreaterOrEqual(new int[] {1, 2, 4, 4, 6}, 3));
//        int x = findUpperBound(List.of(1,1,2,2,2,4,4,4,6,6,8), 8);
//        System.out.println(x);
//        System.out.println(paintersProblem(1,1000000,new ArrayList<>(List.of(1000000,1000000))));
//        System.out.println(aggressiveCows(new ArrayList<>(List.of()), 385));
//        System.out.println(foodPacketDist(new ArrayList<>(List.of(10000, 22000, 36000)), 6));
//        System.out.println(searchMatrix(new int[][] {{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 61));
//        System.out.println(searchInsert(new ArrayList<>(List.of(1,3,5,6,8,10,17,28)), 29));
//        System.out.println(subArrayWithGivenSum(new ArrayList<>(List.of(1,1000000000)), 1000000000));
//        System.out.println(pairsWithGivenDiff(new ArrayList<>(List.of(8,5,1,10,5,9,9,3,5,6,6,2,8,2,2,6,3,8,7,
//                2,5,3,4,3,3,2,7,9,6,8,7,2,9,10,3,8,10,6,5,4,2,3)), 3));
//        System.out.println(searchRange(new ArrayList<>(List.of(1)), 1));
//        allFactors(44);
//        primeSum(1048).stream().forEach(System.out::println);
//        System.out.println(hammingDistance1(new ArrayList<>(Arrays.asList(96, 96, 7, 81, 2, 13 ))));
        System.out.println(pairWithGivenDiff(new ArrayList<>(Arrays.asList(-533, -666, -500, 169, 724, 478, 358, -38,
                -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284,
                718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322)), 369));
    }

    public static int pairWithGivenDiff(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int p1 = 0;
        int p2 = A.size()-1;

        while(p1 < p2 && p2 <= A.size() - 1 && p1 >= 0){
            int diff = A.get(p2)-A.get(p1);
            if(diff == B){
                return 1;
            } else if(diff > B) {
                p1++;
            } else {
                p2++;
            }
            // 478, 358, -38, -536, 705
            // -38 -536 358 478 705
        }
        return 0;
    }
    public static int isPower(int A) {
        int n = A;
        int p = 0;
        if(A==1) return 1;
        for(int a = 2; a*a <= n; a++){
            p = (int) (Math.log(n) / Math.log(a));
            if(Math.pow(a,p) == A){
                return 1;
            }
        }
        return 0;
    }
    public static int hammingDistance(final List<Integer> A) {

        /*
            96 1100000
            96 1100000
            7  0000111
            81 1010001
            2  0000010
            13 0001101

            96-7    5
            96-81   3
            96-2    3
            96-13   5

            7-81    4
            7-2     2
            7-13    2

            81-2    4
            81-13   4

            2-13    4

        */
        int mod = 1000000007;
        long sum = 0;
        for(int j = 0; j < A.size()-1; j++){
            for(int i = j+1; i<A.size(); i++){
                int xor = A.get(j)^A.get(i);
                int setBits = countSetBits(xor);
                setBits = (setBits*2)%mod;
                sum = (sum + setBits) % mod;
            }
        }
        return (int) sum%mod;
    }
    public static int hammingDistance1(final List<Integer> A) {
        long ans = 0;
        long mod = 1000000007;
        for(int i = 0; i<32; i++){
            long ones = 0;
            long zeros = 0;
            for(int x: A){
                if((x&(1<<i)) != 0){
                    ones++;
                } else{
                    zeros++;
                }
            }
            zeros = A.size()-ones;
            ans = (ans + (ones * zeros * 2) % mod) % mod;
        }
        return (int) ans;
    }
    public static ArrayList<Integer> primeSum(int A) {
        /*
         2 is the only even prime
         A/2 -> will be the next num we need to consider
         e.g. 58 -> 58/2 = 29
         108 => 108/2 = 54, 108/3 = 36
         */
        ArrayList<Integer> allPrimes = sieveOfEratosthenes(A);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: allPrimes){
            int n = A-i;
            if(isPrime(n)){
                ans.add(i);
                ans.add(n);
                return ans;
            }
        }
        return ans;
    }
    private static boolean isPrime(int n) {
        for(int i = 2; i*i<=n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    private static ArrayList<Integer> sieveOfEratosthenes(int n) {

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = true;
                }
            }
        }

        ArrayList<Integer> primeNums = new ArrayList<>();
        int idx = 2;
        while (idx < arr.length) {
            if (!arr[idx]) {
                primeNums.add(idx);
            }
            idx++;

        }

        return primeNums;

    }

    public static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=1; i*i<=A; i++)
        {
            if (A%i==0) {
                if (A / i == i)
                    arrayList.add(i);

                else {
                    arrayList.add(i);
                    arrayList.add(A / i);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
    public static ArrayList<Integer> sieve(int A) {
        StringBuilder sb = new StringBuilder();
        sb.reverse().toString();
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean[] prime = new boolean[A + 1];
        for (int i = 0; i <= A; i++)
            prime[i] = true;

        for (int p = 2; p * p <= A; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= A; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= A; i++) {
            arrayList.add(i);
        }

        return arrayList;
    }
    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int n = A.size();
        int left = leftOcuurence(A, B, n);
        int right = rightOcuurence(A, B, n);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(left);
        arr.add(right);
        return arr;
    }
    public static int leftOcuurence(final List<Integer> A, int B, int n){
        int low = 0;
        int high = n-1;
        int idx = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int val = A.get(mid);
            if(val >= B){
                idx = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        if(idx == -1){
            return idx;
        } else {
            return A.get(idx) == B ? idx : -1;
        }
    }
    public static int rightOcuurence(final List<Integer> A, int B, int n){
        int low = 0;
        int high = n-1;
        int idx = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int val = A.get(mid);
            if(val > B){
                high = mid-1;
            } else {
                idx = mid;
                low = mid+1;
            }
        }
        if(idx == -1){
            return idx;
        } else {
            return A.get(idx) == B ? idx : -1;
        }
    }
    public static int pairsWithGivenDiff(ArrayList<Integer> A, int B) {
        /*
            8, 12, 16, 4, 0, 20 - 4
            0, 4, 8, 12, 16, 20

            1, 5, 3, 4, 2
            1, 2, 3, 4, 5

        */

        Collections.sort(A);
        int p1 = 0, p2 = 1;
        HashSet<String> set = new HashSet();

        while (p2<A.size()) {
            int diff = A.get(p2) - A.get(p1);
            if ((diff == B) && !set.contains(p1 + " " + p2)) {
                set.add(p1 + " " + p2);
                p1++;
                p2++;
            } else if(diff < B){
                p2++;
            } else {
                p1++;
            }
        }

        return set.size();
    }
    public static ArrayList<Integer> subArrayWithGivenSum(ArrayList<Integer> A, int B) {
        int p1 = 0, p2 = 0;
        int sum = 0;
        while (p2<A.size()){
            if (sum < B){
                sum+=A.get(p2);
                p2++;
            } else if (sum == B){
                return new ArrayList<>(A.subList(p1,p2));
            } else {
                sum -= A.get(p1);
                p1++;
            }
        }
        if(p2 == A.size()){
            while (p1<p2){
                sum -= A.get(p1);
                p1++;
                if(sum == B){
                    return new ArrayList<>(A.subList(p1,p2));
                }
            }
        }
        return new ArrayList<>(Arrays.asList(-1));
    }
    public static int searchInsert(ArrayList<Integer> A, int B) {
        int n = A.size();
        if(B <= A.get(0)){
            return 0;
        }
        if(B >= A.get(n-1)){
            return n;
        }
        int low = 0;
        int high = n-1;
        int idx = -1;

        while(low <= high){
            int mid = (low+high)/2;
            int val = A.get(mid);
            if(val == B) {
                return mid;
            } else if (val < B){
                idx = mid+1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }
    public static int searchMatrix(int[][] A, int B) {
        int r = A.length;
        int c = A[0].length;
        int row = 0;
        int col = c-1;
        while(row <= r-1 && col >= 0){
            int val = A[row][col];
            if(val == B){
                System.out.println(row+" "+col);
                return 1;
            } else if (val > B){
                col--;
            } else {
                // B > A[mid][col]
                row++;
            }
        }
        return 0;
    }
    public static int foodPacketDist(ArrayList<Integer> A, int B) {
        /*
            if x office can serve p population, then they can serve <p population also
         */
        int n = A.size();
        int low = 0, high = Integer.MAX_VALUE, ans = -1;
        long sum = 0;
        for(int i = 0; i<n; i++){
            high = Math.min(high, A.get(i));
            sum += i;
        }

        while (low<=high){
            int mid = (low+high)/2;
            if(canDistributeXPeople1(A, B, mid)){
                ans = mid;
                low = mid+1;
            } else
                high = mid-1;
        }
        return ans;
    }
    public static boolean canDistributeXPeople1(ArrayList<Integer> A, int offices, int population) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (population == 0) {
                sum += A.get(i);
            } else {
                sum += (A.get(i) / offices);
            }
        }
        return sum >= offices;
    }
    public static boolean canDistributeXPeople(ArrayList<Integer> A, int offices, int population){
        /* can we get max 'population' to fit in single office
        *   50, 100, 150 -> 7
        *   50/ 7 =7, 100/7 = 14, 150/7 = 21
        * */

        int count = 0;
        for(int i = 0; i<A.size(); i++){
            if(A.get(i) < population){
                count += 1;
            } else {
                double officesRequired = Math.ceil((double) A.get(i)/population);
                count += officesRequired;
            }
        }
        if (count<=offices){
            return true;
        }
        return false;
    }
    public static int allocateBooks(ArrayList<Integer> A, int B) {
        /*
            search space [pages] - max [1 student, sum of all values]. min [n student, max(A)]
            if n student can read x pages, they can read <x pages for sure.
            given a page count, see how many students you need to read all books
         */
        int n = A.size();
        if(B>n){
            return -1;
        }
        int low = Integer.MIN_VALUE , high = 0, ans = -1;
        for(int i: A){
            low = Math.max(i, low);
            high += i;
        }
        while (low<=high){
            int mid = (low+high)/2;
            if(canReadBooks(A, B, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
    public static boolean canReadBooks(ArrayList<Integer> A, int students, int pages){
        int count = 1;
        int booksRead = A.get(0);
        for(int i = 1; i<A.size(); i++){
            booksRead += A.get(i);
            if(booksRead > pages){
                booksRead = A.get(i);
                count++;
            }
        }
        if (count>students){
            return false;
        }
        return true;
    }
    public static int aggressiveCows(ArrayList<Integer> A, int B) {
        /*
            search space - answer space => max -> 2 cows - A[n-1]-A[0], min -> n cows - A[1]-A[0]
            if cows cant be placed at x distance then they can also be not placed at >x distance
            now we need to find, if given x, can we place B cows
         */
        Collections.sort(A);
        int n = A.size();
        if(B > n){
            return -1;
        }
        if(n == 2 && B == 2){
            return A.get(1)-A.get(0);
        }
        int low = 1;
        int high = A.get(n-1)-A.get(0);
        int ans = 0;
        while (low<=high){
            int mid = (low+high)/2;
            if(canCowsBePlaced(A, B, mid)){
                ans = mid;
                low = mid+1;
            } else
                high = mid-1;
        }
        return ans;
    }
    public static boolean canCowsBePlaced(ArrayList<Integer> A, int B, int distance){
        int recentlyPlaced = A.get(0);
        int cowsPlaced = 1;
        for(int i = 1; i<A.size(); i++){
            if(A.get(i)-recentlyPlaced >= distance){
                cowsPlaced++;
                recentlyPlaced = A.get(i);
            }
        }
        if(cowsPlaced >= B){
            return true;
        }
        return false;

    }
    public static int paintersProblem(int A, int B, ArrayList<Integer> C) {
        /*
            search space - answer space - max(A) [n painters] sum(A) [ 1 painter]
            we have to minimize time required
            so if n painters can paint in min x time, >x will be true as well.
            finally, we have to just find how many painters are required to paint in x time
            if that number is = A, we can update the answer and look for lower value of x.
            also all the >x will be true as well, so we can update the answer when >=x is valid.
         */
        int n = C.size();
        long low = Integer.MIN_VALUE, high = 0;
        int mod = 10000003;
        for(int i: C){
            low = Math.max(low, i);
            high = (high + i)%mod;
        }
        if(A > n){
            return (int) (((long) low *(long) B)%mod);
        }
        if(A == 1){
            return (int) (((long) high *(long) B)%mod);
        }
        long ans = 0;
        while (low <= high){
            long mid = (low+high) /2;
            if(canPaintInXTime(C, A, mid)){
                ans = mid%mod;
                high = mid-1;
            } else
                low = mid+1;
        }

        return (int) ((ans*B)%mod);
    }
    private static boolean canPaintInXTime(ArrayList<Integer> C, int n, long time){
        int totalTime = 0;
        int count = 1;
        for (int i: C){
            totalTime+=i;
            if(totalTime>time){
                totalTime = i;
                count++;
            }
        }
        if(count <= n){
            return true;
        }
        return false;
    }
    public static int numberGreaterOrEqual(int[] A, int B){
        int n = A.length;
        int low = 0;
        int high = n-1;
        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(A[mid] <= B){
                ans = mid+1;
                low = mid+1;
            } else
                high = mid-1;
        }

        return ans;
    }
    public static int kthPrice(List<Integer> A, int B){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: A){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int ans = 0;
        while (min <= max){
            int mid = (min+max)/2;
            int numbersLessOrEqual = findNumLessOrEqual(A, mid);
            if(numbersLessOrEqual < B){
                min = min+1;
            } else {
                ans = mid;
                max = mid - 1;
            }
        }

        return ans;
    }
    public static int findNumLessOrEqual(List<Integer> A, int k){
        int count = 0;
        for(int i: A){
            if(i <= k)
                count++;
        }
        return count;
    }
    public static int athMagicalNum(int A, int B, int C) {
        /*
            4
            b*1 b*2 b*3 b*4
            c*1 c*2 c*3 c*4

            11
            6   12  18  24  30  36  42 48
            9   18  27  36  45  54  63
            6   9   12  18  24  27  30  36  42  45  48

            Numbers divisible by B and C in range [1, M] = M/B + M/C - M/lcm(B,C)
            if numbers divisible > A
                go left
            else
                go right

         */
            long low = 1;
            long high = Long.MAX_VALUE;
            long ans = 0;
            int mod = 1000000007;

            while (low <= high){
                long mid = low + (high-low)/2;
                long divisibleByB = mid/(long) B;
                long divisibleByC = mid/(long) C;
                long prod = ((long) B * (long) C);
                long lcm = prod / gcd(B, C);
                long divisibleByLcm = mid/lcm;
                long k = divisibleByB + (divisibleByC - divisibleByLcm);
                if(k >= A){
                    ans = mid;
                    high = mid-1;
                } else if (k < A){
                    low = mid+1;
                }
            }

        return (int) (ans%mod);
    }
    private static long gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
    public static int specialInteger(ArrayList<Integer> A, int B) {
        /*
            search space [1, len] = mid
            for each mid, see if all subarrays have sum > B (using sliding window)
            if(true){
                go right and see if any bigger k exists
            else
                go left to see if we have smaller k satisfying this condition
         */


        int low = 1;
        int high = A.size();
        int ans = 0;
        while (low <= high){
            int mid = (low+high)/2;
            if(checkSubarraySum(A, mid, B)){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }
    private static boolean checkSubarraySum(ArrayList<Integer> A, int k, int sumExpected){
        long sumK = 0;
        for(int i = 0; i<k; i++){
            sumK += (long) A.get(i);
        }
        if(sumK > sumExpected){
            return false;
        }

        for(int i = 1; i<=A.size()-k; i++){
            sumK -= (long) A.get(i-1);
            sumK += (long) A.get(i+k-1);
            if(sumK > sumExpected){
                return false;
            }
        }
        return true;
    }
    public static int rotatedSortedArraySearch(final List<Integer> A, int B) {

        // find rotation index (min elem in arr)
        int n = A.size();
        int low = 0;
        int high = n-1;
        int rotationIdx = -1;
        while (low<=high){
            int mid = (low+high)/2;
            int val = A.get(mid);
            if(val == B){
                return mid;
            }
            int left = A.get(mid-1);
            int right = A.get(mid+1);
            if(left > val && right > val){
                rotationIdx = mid;
                break;
            }
            if(val >= A.get(0)){
                // left half so go right
                low = mid+1;
            } if(val < A.get(0)){
                // right half, so go left
                high = mid-1;
            }
            if(low == n-1 || high == 0){
                break;
            }
        }

        if(rotationIdx == -1){
            return binarySearch(A, B, 0, n-1);
        } else if (B < A.get(0)){
            // right half
            return binarySearch(A, B, rotationIdx, n-1);
        }
        return binarySearch(A, B, 0, rotationIdx-1);
    }
    private static int binarySearch(List<Integer> A, int B, int low, int high){
        int idx = -1;
        while (low <= high){
            int mid = (low+high)/2;
            int val = A.get(mid);
            if(val == B){
                idx = mid;
                break;
            } else if (val > B){
                high = mid-1;
            } else
                low = mid+1;
        }
        return idx;
    }
    public static int sqrt(int A){
        long low = 1;
        long high = A;
        long ans = 0;
        while (low <= high){
            long mid = low + (high-low)/2;
            long prod = mid*mid;
            if(prod == A){
                return (int) mid;
            } else if (prod < A){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return (int) ans;
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int r = A.size();
        int c = A.get(0).size();

        int k = (r+c)/2;
        double ans = findMedianSortedMatrixHelper(A, k);
        if(((r*c) & 1) == 0){ // even
            k = k-1;
            double y = findMedianSortedMatrixHelper(A, k);
            ans = (ans+y)/2;
        }
        return (int) ans;

    }
    public static double findMedianSortedMatrixHelper(ArrayList<ArrayList<Integer>> A, int k){
        int r = A.size();
        int c = A.get(0).size();
        int low = Integer.MAX_VALUE;
        for (ArrayList<Integer> a: A){
            low = Math.min(low, a.get(0));
        }

        int high = Integer.MIN_VALUE;
        for (ArrayList<Integer> a: A){
            high = Math.max(high, a.get(c-1));
        }


        double ans = 0.0;
        while (low <= high){
            int mid = (low+high)/2;

            int count = 0;
            for (ArrayList<Integer> a: A){
                count += findLowerBound(a, mid);
            }

            if(count <= k){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return ans;
    }
    public static double findMedianSortedArrays2(List<Integer> A, List<Integer> B){
        int n = A.size();
        int m = B.size();
        double ans = 0.0;

        int k = (n+m)/2; // exactly k elements less than median
        ans = findMedianSortedArraysHelper(A, B, k);
        if(((n+m)/2) % 2 == 0){
            k = ((n+m)/2)-1;
            double y = findMedianSortedArraysHelper(A, B, k);
            ans = (ans+y)/2;
        }

        return ans;
    }
    public static double findMedianSortedArraysHelper(List<Integer> A, List<Integer> B, int k){
        int n = A.size();
        int m = B.size();
        int low = Math.min(A.get(0), B.get(0));
        int high = Math.max(A.get(n-1), B.get(m-1));

        double ans = 0.0;
        while (low <= high){
            int mid = (low+high)/2;

            int count = 0;
            count += findLowerBound(A, mid);
            count += findLowerBound(B, mid);

            if(count <= k){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return ans;
    }
    public static int uniqueElem(int[] A){
        /*
            first occurrence is 0/ even before unique elem
            first occurrence is odd after unique elem
        */
        int n = A.length;
        if(n == 1){
            return A[0];
        }
        if(A[0] != A[1]){
            return A[0];
        }
        if(A[n-1] != A[n-2]){
            return A[n-1];
        }

        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = (low+high)/2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]){
                return A[mid];
            }
            if(A[mid] == A[mid-1]){
                mid = mid-1;
            }
            if(mid%2 == 0){
                // even
                low = mid+2;
            }
            else {
                // odd
                high = mid-1;
            }

        }
        return 0;
    }
    public static int findLowerBound(List<Integer> A, int target){
        /*
            Lower bound -
            if target is present, return index 1st occurrence of target
            else return index of next greater element
            if no greater element exists return len(A)
         */
        int n = A.size();
        if(target > A.get(n-1)){
            return n;
        }

        int low = 0;
        int high = n-1;
        int ans = 0;
        while (low <= high){
            int mid = (low+high)/2;
            if(A.get(mid) >= target){
                ans = mid;
                high = mid-1;
            } else
                low = mid+1;
        }
        return ans;
    }
    public static int findUpperBound(List<Integer> A, int target){
        /*
            Upper bound -
            return index of next greater element
            if no greater element exists return len(A)
         */
        int n = A.size();
        int low = 0;
        int high = n-1;
        int ans = n;
        while (low<=high){
            int mid = (low+high)/2;
            if(A.get(mid) > target){
                ans = mid;
                high = mid-1;
            } else
                low = mid+1;

        }

        return ans;
    }
    public static double findMedianSortedArrays(List<Integer> A, List<Integer> B) {
        //O(log n + log m)
        int l1 = A.size();
        int l2 = B.size();
        if(l2 < l1){
            return findMedianSortedArrays(B, A);
        }
        if(l1 == 0){
            return l2%2 != 0 ? B.get(l2/2) : (B.get((l2/2)-1) + B.get(l2/2))/2.0;
        }

        int l = l1+l2;
        int low = 0;
        int high = l1;

        while (low <= high){
            int mid1 = (low+high)/2;
            int mid2 = (l+1)/2 - mid1;
            int left1 = mid1 == 0 ? Integer.MIN_VALUE : A.get(mid1-1);
            int right1 = mid1 == l1 ? Integer.MAX_VALUE : A.get(mid1);

            int left2 = mid2 == 0 ? Integer.MIN_VALUE : B.get(mid2-1);
            int right2 = mid2 == l2 ? Integer.MAX_VALUE : B.get(mid2);

            if(left1 <= right2 && left2 <= right1){
                // correct partition
                if(l%2 == 0){
                    return  (Math.max(left1, left2) + Math.min(right1,right2)) /2.0;
                }
                return Math.max(left1, left2);

            }
            if(left2 > right1){
                // move left
                low = mid1+1;
            }
            if(left1>right2){
                high = mid1-1;
            }
        }
        return 0.0;
    }
    public static int binarySearchRotated(final int[] A, int B) {
        int n = A.length;
        if(n==1 && A[0] == B){
            return 0;
        }
        int pivot = -1;
        if(A[1] < A[0]){
            pivot = 1;
        }
        if(A[n-2] > A[n-1]){
            pivot = n-1;
        }
        if(A[0] < A[n-1]){
            pivot = 0;
        }

        if(pivot == -1){
            int low = 1;
            int high = n-2;

            while(low <= high){
                int mid = (low+high)/2;
                if(A[mid] < A[mid-1] && A[mid] < A[mid+1]){
                    pivot = mid;
                    break;
                }
                if(A[mid] < A[0]){
                    // we are in right half, go left
                    high = mid-1;
                }
                if(A[mid] > A[n-1]){
                    // we are in left half, go right
                    low = mid+1;
                }
            }
        }
        if(A[pivot] == B){
            return pivot;
        }

        int low = 0, high = n-1;
        if(pivot == 0){
            low = 0;
            high = n-1;
        } else if(B <= A[pivot-1] && B >= A[0]){
            // binary search in left half
            low = 0;
            high = pivot-1;
        } else if(B <= A[n-1] && B>A[pivot]){
            // binary search in right half
            low = pivot+1;
            high = n-1;
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == B){
                return mid;
            } else if (A[mid] > B){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }
    public static int countTotalSetBits(int A) {
        A = A+1;
        int totalBits = A/2;
        int mod = 1000000007;
        int i = 0;

        while((1<<i) <= A){
            i++;
        }
        i++;
        int pairs = (A/(1<<i))/2;
        totalBits += pairs*i;

        return totalBits;
    }
    private static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    /*
    00000000
    00000001    1   1
    00000010    1   2
    00000011    2   3
    00000100    1   4
    00000101    2   5
    00000110    2   6
    00000111    3   7
    00001000    1   8
    00001001    2   9
    00001010    2   10
    00001011    3   11
    00001100    2   12
    00001101    3   13
    00001110    3   14
    00001111    4   15
    00010000    1   16
    00010001    2   17

    17 =>   0 = 9
            1 = 8
            2 = 8
            3 = 8
            4 = 2

     */
    public static int singleNumber(final int[] A) {
        int ans = 0;
        for(int i = 0; i<32; i++){
            int bitCount = 0;
            for(int a: A){
                a = a>>i;
                if((a&1)==1)
                    bitCount++;
            }
            if (bitCount != 0) {
                int bitRemaining = bitCount%3;
                ans += (int) (Math.pow(2,i)*bitRemaining);
            }
        }
        return ans;
    }
    public static int SingleNumberII(int[] A) {
        for(int i = 1; i<A.length; i++){
            A[0] = A[0]^A[i];
        }
        System.out.println(A[0]);
        return A[0];
    }

}

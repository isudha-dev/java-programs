package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems15_190124 {

    public static void main(String[] args) {
//        List<Integer> A = new ArrayList<>(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40));
//        List<Integer> B = new ArrayList<>(Arrays.asList(-2));
//        System.out.println(findMedianSortedArrays(A, B));

//        System.out.println(addNumbers(5,7));
//        System.out.println(smallestGreaterNum("892795"));
        //892957  892579
//        System.out.println(isPalindrome(121121));
//        divide(116,16);

//        findPermS(100000, 603828039791327040L);
//        titleToNumber("BCD");
        System.out.println(convertToTitleS(1434));
    }

    public static int titleToNumber(String A) {

        int result = 0;
        for(char c: A.toCharArray()){
            int d = c - 'A'+1;
            result = result*26+d;
        }
        return result;
        /*
         2*26^2 + 3*26^1 + 4*26^0
         26(2*26 + 3) + 4
         26(26(2)+3)+4 = 1434

         ((((1434-4)/26)-3)/26)-2 = 0
         */
    }

    public static String convertToTitleS(int A){
        StringBuilder sb=new StringBuilder("");
        while(A>0){
            A--;
            int rem=A%26;
            sb.append((char)(rem+'A'));
            A=A/26;
        }
        return sb.reverse().toString();
    }

    public static String convertToTitle(int A) {
        int num = A;
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int mul = num/26;
            int n = num - (26*mul);
            if(n == 0){
                n = 26;
            }
            char ch = (char) (n-1+'A');
            sb.append(ch);
            num = (num-n)/26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        //get positive values
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int result = 0;
        while(pDividend>=pDivisor){
            //calculate number of left shifts
            int numShift = 0;
            while(pDividend>=(pDivisor<<numShift)){
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }

        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }else{
            return -result;
        }
    }

    public static int[] findPermS(int A, long B) {
        long[] fact = new long[21];
        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = i * fact[i - 1];
        }
        int[] ans = new int[A];
        int curr = 0;
        for (int i = 0; i < A - 20; i++) {
            ans[i] = i + 1;
            curr = i;
        }
        ArrayList < Integer > l1 = new ArrayList < > ();
        for (int i = Math.max(A - 20, 1); i <= A; i++) {
            l1.add(i);
        }
        B--;
        for (int i = Math.min(20, A - 1); i >= 0; i--) {
            int idx = (int)(B / fact[i]);
            B -= idx * fact[i];
            ans[curr++] = l1.get(idx);
            l1.remove(idx);
        }
        return ans;
    }
    public static int[] findPerm(int A, long B) {
        /*
        5 -> 5! = 120 -> 116th (0-115)
        1,2,3,4,5
        115/4! => 115/24 = 4
        115%24 => 19

        1,2,3,4
        19/3! => 19/6 => 3
        19%6 => 1

        1,2,3
        // 5 4 1 2 3
         */

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i<=A; i++){
            nums.add(i);
        }
        int[] ans = new int[A];
        findKthValue(nums, B-1, A-1, ans, 0);
        return ans;
    }

    static void findKthValue(ArrayList<Integer> nums, long B, long remainingNum, int[] ans, int ansIdx){
        if(B == 0){
            int n = nums.size();
            for (int i = 0; i<n; i++){
                ans[i+ansIdx] = nums.get(0);
                nums.remove(0);
            }
            return;
        }
        long fact = factorial(remainingNum);
        int idx = (int) (B/ fact);
        ans[ansIdx] = nums.get(idx);
        nums.remove(idx);

        B = B%fact;
        findKthValue(nums, B, remainingNum-1, ans, ansIdx+1);
    }

    static long factorial(long i){
        if(i == 1){
            return 1;
        }
        return factorial(i-1)*i;
    }

    public static int isPalindrome(int A) {
        String str = String.valueOf(A);
        int p1 = 0;
        int p2 = str.length()-1;
        while(p1<=p2){
            if(str.charAt(p1) != str.charAt(p2)){
                return 0;
            }
            p1++;
            p2--;
        }
        return 1;

    }

    public static String smallestGreaterNum(String A) {
        int n = A.length();
        int[] num = Arrays.stream(A.split("")).mapToInt(Integer::parseInt).toArray();
        int idx = -1;
        for(int i = n-1; i>0; i--){
            if(num[i]>num[i-1]){
                idx = i-1;
                break;
            }
        }
        if(idx == -1){
            return "-1";
        } else {
            // swap idx with last char
            int idx2 = n-1;
            for(int i = n-1; i > idx; i--){
                if(num[i] > num[idx]){
                    idx2=i;
                    break;
                }
            }

            int temp = num[idx];
            num[idx] = num[idx2];
            num[idx2] = temp;

            int[] tempArr = Arrays.stream(Arrays.copyOfRange(num, idx+1, n)).sorted().toArray();
            System.arraycopy(tempArr, 0, num, idx+1, n-idx-1);
            StringBuilder sb = new StringBuilder();
            for(int i: num){
                sb.append(i);
            }
            return sb.toString();
//            return Arrays.stream(num).mapToObj(Integer::toString).collect(Collectors.joining());
        }
    }

    static int addNumbers(int A, int B) {
        while(B!=0){
            int carry=A&B;
            A=A^B;
            B=carry<<1;
        }
        return A;
    }

    public static double findMedianSortedArrays(final List<Integer> A, final List<Integer> B){
        int n = A.size();
        int m = B.size();
        if(m<n)
            return findMedianSortedArrays(B, A);

        int low = 0;
        int high = n;
        while (low<=high){
            int cut1 = (low+high)/2;
            int cut2 = ((n+m+1)/2)-cut1; // +1 to ensure this works for both odd and even length

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : A.get(cut1-1);
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : B.get(cut2-1);

            int r1 = cut1 == n ? Integer.MAX_VALUE : A.get(cut1);
            int r2 = cut2 == m ? Integer.MAX_VALUE : B.get(cut2);

            if(l1<=r2 && l2 <= r1){
                // we are in correct partition
                if((n+m) % 2 != 0){
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1,l2) + Math.min(r1, r2))/ 2.0;
                }
            } else if(l1>r2){
                high = cut1-1;
            } else {
                low = cut1+1;
            }
        }
        return 0.0;
    }

}

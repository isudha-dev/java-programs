package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problems15_170124 {

    public static void main(String[] args) {
//        List<Integer> A = new ArrayList<>(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40));
//        List<Integer> B = new ArrayList<>(Arrays.asList(-2));
//        System.out.println(findMedianSortedArrays(A, B));

//        System.out.println(addNumbers(5,7));
        System.out.println(smallestGreaterNum("892795"));
        //892957  892579
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
            int cut2 = ((n+m+1)/2)-cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : A.get(cut1-1);
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : B.get(cut2-1);

            int r1 = cut1 == n ? Integer.MAX_VALUE : A.get(cut1);
            int r2 = cut2 == m ? Integer.MAX_VALUE : B.get(cut2);

            if(l1<=r2 && l2 <= r1){
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

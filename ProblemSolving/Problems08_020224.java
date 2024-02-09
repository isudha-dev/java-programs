package ProblemSolving;

import java.util.*;

public class Problems08_020224 {
    public static void main(String[] args) {
        System.out.println(PairsWithGivenDiff(new ArrayList<>(Arrays.asList(1,2)), 0));
//        System.out.println(solve(new int[]{1,1,1,2,2}, 0));
    }

    public static ArrayList<Integer> subarrayWithGivenSum(ArrayList<Integer> A, int B) {
        int n = A.size();
        if(n == 1 && A.get(0) == B){
            return A;
        }
        if(n == 1) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        int p1 = 0, p2 = 1;
        int sum = A.get(p1);
        while (p2<n){
            if(sum > B){
                sum -=A.get(p1);
                p1++;
            } else if (sum < B){
                sum += A.get(p2);
                p2++;
            } else {
                return new ArrayList<>(A.subList(p1,p2));
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

    public static int PairsWithGivenDiff(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        if(n == 1) return 0;
        int p1 = 0, p2 = 1;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        while (p2<n){
            if(B == 0 && p1 == p2){
                if(p2<n-1)
                    p2++;
                else
                    break;
            }
            int diff = A.get(p2)-A.get(p1);
            if(diff == B){
                if(!set.contains(A.get(p1))) {
                    count++;
                    set.add(A.get(p1));
                }
                p1++;
                p2++;
            } else if(diff > B){
                p1++;
            } else {
                p2++;
            }
        }

        return count;
    }

    public static int maxArea(ArrayList<Integer> A) {

        return 0;
    }
}

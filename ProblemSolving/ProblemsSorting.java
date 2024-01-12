package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemsSorting {
    public static void main(String[] args) {
        merge2sortedList(new ArrayList<>(Arrays.asList(-4,-3,0)), new ArrayList<>(Arrays.asList(2)));
    }

    public static ArrayList<Integer> merge2sortedList(final List<Integer> A, final List<Integer> B) {
        int p1 = 0, p2 = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (p1<A.size() && p2<B.size()){
            if(A.get(p1) < B.get(p2)){
                ans.add(A.get(p1));
                p1++;
            } else {
                ans.add(B.get(p2));
                p2++;
            }
        }

        while (p1<A.size()){
            ans.add(A.get(p1++));
        }
        while (p2<B.size()){
            ans.add(B.get(p2++));
        }
        return ans;
    }
}

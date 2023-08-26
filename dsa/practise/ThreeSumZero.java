package dsa.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSumZero {
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        int n = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i< n; i++){
            map.put(A.get(i), map.getOrDefault(A.get(i),0)+1);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i : A){
            set.add(i);
        }

        A = new ArrayList<>();
        for(int i: set){
            A.add(i);
        }
        n = A.size();
        Collections.sort(A);

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int freq1 = map.get(A.get(i));
                int freq2 = map.get(A.get(j));
                int sum = A.get(i)+A.get(j);
                int actSum = sum*-1;
                if(map.containsKey(actSum)){
                    if(actSum == A.get(i) && freq1==1){
                        continue;
                    }
                    if(actSum == A.get(j) && freq2==1){
                        continue;
                    }
                    if(A.get(i)<=A.get(j) && A.get(j)<=actSum){
                        ans.add(new ArrayList<>(Arrays.asList(new Integer[]{A.get(i), A.get(j), actSum})));
                    }
                }
            }
        }

        if(map.containsKey(0) && map.get(0) == 3){
            ans.add(new ArrayList<>(Arrays.asList(new Integer[]{0,0,0})));
        }

        for(int i: A){
            if(map.get(i) >= 2){
                int actSum = (i+i)*-1;
                if(map.containsKey(actSum) && i < actSum){
                    ans.add(new ArrayList<>(Arrays.asList(new Integer[]{0,0,0})));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        //1, -4, 0,0,5,-5,1,0,-2,4,-4,1,-1,-4,3,4,-1,-1,-3
        List<Integer> temp = List.of(-5,5,5,-1,0,-5,-1,-1,-3,3,2,5,1,0,5,-1);
//        temp.add(-5);
//        temp.add(2);
//        temp.add(1);
//        temp.add(3);
        System.out.println(threeSum(new ArrayList<>(Arrays.asList(new Integer[] { -5,5,5,-1,0,-5,-1,-1,-3,3,2,5,1,0,5,-1}))));
    }

}

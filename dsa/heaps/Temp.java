package dsa.heaps;

import java.util.Arrays;
import java.util.HashMap;

public class Temp {
    public static void main(String[] args) {
        solve1(new int[] {7,6,3,4,8,8,7,12,13,10,13, 16,17, 18});
        // 3,4,6,7 |,7,8,8,| 10,12,13| ,13,| 16|,17|,18|
    }

    public static int solve1(int[] A) {
        int count = 1;
        int i = 0;
        while(i < A.length){
            int num = A[i];
            int idx = i+1;
            while (num > A[idx]){
                idx++;
            }
            count++;
            i = idx;
        }

        return count;
    }

    public static int solve(int[] A) {
        HashMap<Integer, Integer> mapOrg = new HashMap<>();
        HashMap<Integer, Integer> mapNew = new HashMap<>();

        for(int i = 0; i<A.length; i++){
            mapOrg.put(A[i], i);
        }

        Arrays.sort(A);
        for(int i = 0; i<A.length; i++){
            mapNew.put(A[i], i);
        }

        int countSame = 0;
        int countDiff = 0;
        boolean elemDiff = false;

        for(int i = 0; i<A.length; i++){
            int num = A[i];
            if(mapOrg.get(num) != mapNew.get(num) && !elemDiff ){
                elemDiff = true;
                countDiff++;
            } else if(mapOrg.get(num) == mapNew.get(num)) {
                elemDiff = false;
                countSame++;
            }
        }
        return countDiff+countSame;
    }
}

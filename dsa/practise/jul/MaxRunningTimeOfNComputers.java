package dsa.practise.jul;

import java.util.Arrays;
import java.util.Collections;

public class MaxRunningTimeOfNComputers {

    public static long maxRunTime(int n, int[] batteries) {
        long sum = 0l;

        while (true)  {
            batteries = Arrays.stream(batteries).boxed()
                        .sorted(Collections.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();
            if (batteries[n-1] == 0) break;;

            int addition = batteries[n-1];
            sum += addition;
            for(int k = 0; k < n; k++) {
                batteries[k] = batteries[k] - addition;
            }
        }

        return sum;
    }

    public static long maxRunTime1(int n, int[] batteries) {
        long ans = 0l;
        long batteriesSum = 0;
        for(int i: batteries){
            batteriesSum += i;
        }

        long low = 1;
        long high = batteriesSum/n;

        while (low <= high){
            long mid = (low+high)/2;
            if(check(n, mid, batteries)){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    public static boolean check(int n, long mid, int[] batteries) {
        long target = n*mid;
        long batteriesSum = 0l;

        for(int i: batteries) {
            if(i < mid){
                batteriesSum += i;
            } else {
                batteriesSum += mid;
            }
            if(batteriesSum >= target){
                return true;
            }
        }
        return batteriesSum >= target;
    }

    public static void main(String[] args) {
        System.out.println(maxRunTime(2, new int[] {3,3,3}));
    }

}

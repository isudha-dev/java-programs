package dsa.practise.jul;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > prevEnd){
                cnt++;
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return cnt;
    }

}

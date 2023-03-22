package primer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeDiff {

    public static void main(String[] args) {
        ArrayList<String> timePoints = new ArrayList<>(Arrays.asList(new String[] { "02:00", "23:59", "00:00" }));
        findMinDifference(timePoints);
    }

    static int findMinDifference(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;

        int[][] arr = new int[timePoints.size()][2];
        int idx = 0;
        for (String s : timePoints) {
            String[] nums = s.split(":");
            arr[idx][0] = Integer.parseInt(nums[0]) == 0 ? 24 : Integer.parseInt(nums[0]);
            arr[idx][1] = Integer.parseInt(nums[1]) == 0 ? 60 : Integer.parseInt(nums[1]);
            idx++;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int hourDiff = 0, minuteDiff = 0;
                if (arr[i][0] != arr[j][0]) {
                    hourDiff = Math.abs(arr[i][0] - arr[j][0]);
                    if (hourDiff > 12) {
                        hourDiff = 24 - hourDiff;
                    }
                    hourDiff *= 60;
                }

                minuteDiff = Math.abs(arr[i][1] - arr[j][1]);
                if (minuteDiff != 0) {
                    hourDiff -= 60;
                }

                minDiff = Math.min(minDiff, hourDiff + minuteDiff);
            }
        }

        return minDiff;
    }

}

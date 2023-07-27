package dsa.practise.jul;

public class MinimumSpeedToArriveOnTime {

    public int minSpeedOnTime(int[] dist, double hour) {

        int min = 1, max = 10000007;
        int n = dist.length;
        int ans = -1;
        while (min <= max) {
            int mid = (min + max)/2;
            int sum = 0;
            for(int i = 0; i < n-1; i++) {
                sum += Math.ceil(dist[i])/mid;
            }
            sum += dist[n-1]/mid;
            if(sum > hour) {
                min = mid+1;
            } else {
                ans = mid;
                max = mid - 1;
            }
        }

        return ans;
    }

}

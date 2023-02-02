package practise;

public class ShortestLenMaxMin {

    public static void main(String[] args) {

    }

    public static int minLen(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int latestMax = -1;
        int latestMin = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                if (latestMax != -1) {
                    ans = Math.min(ans, i - latestMax + 1);
                }
                latestMin = i;
            }
            if (arr[i] == max) {
                if (latestMin != -1) {
                    ans = Math.min(ans, i - latestMin + 1);
                }
                latestMax = i;
            }
        }

        return ans;

    }

}

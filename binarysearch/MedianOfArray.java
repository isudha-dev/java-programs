package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {

    public static void main(String[] args) {
        MedianOfArray moa = new MedianOfArray();
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(new Integer[] { -41, -4, 15, 17, 28, 30, 40 }));
        List<Integer> b = new ArrayList<Integer>(Arrays.asList(new Integer[] { -41, -40, -35, -30, -8, 6, 6, 15, 24 }));
        int n = a.size();
        int m = b.size();
        int k = (n + m) / 2;
        double x = moa.findMedianSortedArraysHelper(a, b, k);
        double ans = x;
        if (((n + m) & 1) != 1) {
            k = ((n + m) / 2) - 1;
            double y = moa.findMedianSortedArraysHelper(a, b, k);
            ans = (x + y) / 2;
        }
        System.out.println(ans);
    }

    public double findMedianSortedArraysHelper(final List<Integer> a, final List<Integer> b, int k) {

        int low = Math.min(a.get(0), b.get(0));
        int high = Math.max(a.get(a.size() - 1), b.get(b.size() - 1));
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            count += findSmallerElements(a, mid);
            count += findSmallerElements(b, mid);

            if (count < k) {
                low = mid + 1;
            } else if (count > k) {
                ans = mid;
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public int findSmallerElements(List<Integer> a, int target) {

        if (target > a.get(a.size() - 1)) {
            return a.size();
        }
        int low = 0;
        int high = a.size() - 1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans + 1;
    }

    public double findMedianSortedArraysTemp(final List<Integer> a, final List<Integer> b) {
        int n = a.size();
        int m = b.size();

        if (n > m)
            return findMedianSortedArraysTemp(b, a);

        int low = 0, high = n;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 - 1);
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b.get(cut2 - 1);

            int right1 = (cut1 == n) ? Integer.MAX_VALUE : a.get(cut1);
            int right2 = (cut2 == m) ? Integer.MAX_VALUE : b.get(cut2);

            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return (Math.max(left1, left2));
            }
            if (left1 > right2) {
                high = cut1 - 1;
            }
            if (left2 > right1) {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }

}

package dsa.twopointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater cm = new ContainerWithMostWater();
        System.out.println(cm.maxArea(new int[] { 2, 5, 4, 7, 3, 6, 5, 4, 3, 1 }));
    }

    public int maxArea(int[] A) {
        int p1 = 0, p2 = A.length - 1;
        int ans = Integer.MIN_VALUE;

        while (p1 < p2) {
            int height = Math.min(A[p1], A[p2]);
            int width = p2 - p1;
            int area = height * width;
            ans = Math.max(ans, area);
            if (A[p1] <= A[p2]) {
                p1++;
            } else {
                p2--;
            }
        }

        return ans;
    }

}

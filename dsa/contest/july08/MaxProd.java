package dsa.contest.july08;

public class MaxProd {

    public static void main(String[] args) {
        int s = solve(new int[]{3, -3, 0, 2, 6});
        System.out.println(s);
    }

    public static int solve(int[] A) {
        if(A.length == 3){
            return A[0]*A[1]*A[2];
        }
        int max1 = Integer.MIN_VALUE , max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;;
        for (int n : A) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        return Math.max(max1*max2*max3, max1*min1*min2);

    }
}

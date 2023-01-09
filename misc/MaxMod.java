
public class MaxMod {

    public static void main(String[] args) {

        System.out.println(solve(new int[] { 33, 82, 75, 4, 52, 74, 79, 46, 18, 73, 1, 83, 46, 94, 44, 86, 40, 1, 46,
                24, 99, 16, 88, 6, 66, 17, 1 }));
    }

    static int solve(int[] A) {
        int countEven = 0;
        int countOdd = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        return Math.min(countEven, countOdd);
    }

}
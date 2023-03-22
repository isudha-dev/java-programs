package primer;

public class OverlapRect {

    public static void main(String[] args) {

    }

    static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        // checks if 2nd rectangle is present at top or bottom side of the 1st rectangle
        if (F >= D | H <= B) {
            return 0;
        }

        // checks if 2nd rectangle is present at left or right side of the 1st rectangle
        else if (E >= C | G <= A) {
            return 0;
        }

        // if both are condtions are not true then it will be overlapping
        else {
            return 1;
        }

    }

}

package binaryproblems;

public class DivideInteger {

    public static void main(String[] args) {
        divide(101, 7);
    }

    static int divide(int A, int B) {
        int divident = A;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int multipler = (B << i);
            if (multipler <= divident) {
                res += multipler;
                divident = divident - multipler;
            }
        }

        return res;
    }
}

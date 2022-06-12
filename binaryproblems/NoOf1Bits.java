package binaryproblems;

public class NoOf1Bits {

    public static void main(String[] args) {

        System.out.println(numSetBitsX(20));
    }

    // approach long division
    static int numSetBits(int A) {
        int division = A;
        int remainder;
        int count = 0;

        while (division != 0) {
            remainder = division % 2;
            division = division / 2;
            if (remainder == 1) {
                count++;
            }
        }

        return count;
    }

    static int numSetBitsX(int A) {
        int count = 0;
        int temp = A & (A - 1);
        while (temp != 0) {
            count++;
            temp &= (temp - 1);
        }
        count++;

        return count;
    }

}

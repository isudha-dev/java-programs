package binaryproblems;

// https://www.scaler.com/academy/mentee-dashboard/class/29827/homework/problems/936?navref=cl_tt_lst_nm
public class StrangeEquality {
    public static void main(String[] args) {
        System.out.println(solve(1));
    }

    // flip the bits to get X
    // add 2^i to get Y, where i is msb(A) + 1
    static int solve(int A) {
        int msb = getMsb(A);
        int X = flipBits(A);
        int Y = (int) Math.pow(2, msb + 1);

        return X ^ Y;
    }

    private static int getMsb(int A) {
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & A) > 0) {
                return i;
            }
        }
        return -1;
    }

    private static int flipBits(int A) {
        int flippedNum = 0;
        int i = 0;
        while (A != 0) {
            if ((A & 1) == 0) {
                flippedNum += Math.pow(2, i);
            }
            i++;
            A = A >> 1;
        }

        return flippedNum;
    }

}

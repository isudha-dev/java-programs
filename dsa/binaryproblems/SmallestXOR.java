package dsa.binaryproblems;

public class SmallestXOR {

    public static void main(String[] args) {

    }

    static int solve(int A, int B) {
        int setBitsOfA = 0;

        for (int i = 0; i < 32; i++) {
            setBitsOfA += ((A & (1 << i)) != 0) ? 1 : 0;
        }

        if (setBitsOfA == B) {
            return A;
        } else if (setBitsOfA < B) {
            int toSet = B - setBitsOfA;
            for (int i = 0; i < 32 && toSet > 0; i++) {
                if ((A & (1 << i)) == 0) {
                    toSet--;
                    A = A | (1 << i);
                }
            }
        } else if (setBitsOfA > B) {
            int toUnset = setBitsOfA - B;
            for (int i = 0; i < 32 && toUnset > 0; i++) {
                if ((A & (1 << i)) != 0) {
                    toUnset--;
                    A = A & ~(1 << i);
                }
            }
        }

        return A;
    }

}

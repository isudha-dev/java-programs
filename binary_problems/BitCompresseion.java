package binary_problems;

public class BitCompresseion {

    public static void main(String[] args) {
        System.out.println(compressBits(new int[] { 1, 3, 5 }));
    }

    static int compressBits(int[] A) {

        int xor = 0;
        for (int i : A) {
            xor ^= i;
        }

        return xor;
    }

}

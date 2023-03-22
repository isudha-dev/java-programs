package dsa.binaryproblems;

public class SingleNum3 {
    public static void main(String[] args) {
        System.out.println(solve(new int[] { 1, 2, 3, 1, 2, 4 }));
    }

    static int[] solve(int[] A) {
        int xor = 0;

        // Step 1 : Taking XOR of all elements
        for (int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];
        }

        // Step 2 : get the 1st set bit or any set bit
        int count = 0;
        while (xor > 0) {
            if ((xor & 1) == 1)
                break;
            xor >>= 1;
            count++;
        }

        // Step 3 : the set bit we got from step 2 will be present in any of the two
        // elements in the answer
        // So, we XOR all the elements with set bit from step 2 to get our first
        // elements
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < A.length; i++) {
            if (checkBitIsSet(A[i], count)) {
                num1 = num1 ^ A[i];
            } else {
                num2 = num2 ^ A[i];
            }
        }

        int[] ans = new int[2];
        // We have to return the answer in sorted order
        ans[0] = num1 < num2 ? num1 : num2;
        ans[1] = num2 > num1 ? num2 : num1;

        return ans;
    }

    private static boolean checkBitIsSet(int num, int pos) {
        int number = num;
        while (pos > 0) {
            number = number >> 1;
            pos--;
        }

        if ((number & 1) == 1)
            return true;
        return false;
    }

}

package binaryproblems;

// https://www.scaler.com/academy/mentee-dashboard/class/29825/assignment/problems/189/submissions
public class AddBinaryString {

    public static void main(String[] args) {
        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));
    }

    // 1001110001111010101001110
    // 1001110001111010101001110

    static String addBinary(String A, String B) {
        StringBuffer sb = new StringBuffer();
        int aLen = A.length();
        int bLen = B.length();

        int sum = 0;
        int carry = 0;
        int i = 0;
        while (i < aLen || i < bLen || carry != 0) {
            if (i < aLen && i < bLen) {
                sum = (A.charAt(aLen - i - 1) - '0') + (B.charAt(bLen - i - 1) - '0') + carry;
            } else if (i < aLen) {
                sum = (A.charAt(aLen - i - 1) - '0') + carry;
            } else if (i < bLen) {
                sum = (B.charAt(bLen - i - 1) - '0') + carry;
            } else if (i >= aLen && i >= bLen && carry != 0) {
                sum = carry;
            }
            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
            i++;
        }

        sb.reverse();
        return sb.toString();
    }

}

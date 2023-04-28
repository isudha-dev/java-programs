package dsa.arrays;

// https://leetcode.com/problems/add-digits/
public class AddDigitsLC {

    public static void main(String[] args) {
        System.out.println( addDigits(5673));
    }

    public static int addDigits(int num) {

        int sum;

        while(true) {
            sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
            if(sum < 10){
                break;
            }

        }
        return sum;

    }


}

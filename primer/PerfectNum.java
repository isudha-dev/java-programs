package primer;

public class PerfectNum {
    public static void main(String[] args) {
        int num = 496;

        if (MyUtils.isPrime(num)) {
            System.out.println("NO");
        } else {
            int sum = 1;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            if (sum == num) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}

package dsa.primer;

public class prime {

    public static void main(String[] args) {
        int i = 1721;
        boolean prime = true;
        if (i <= 1) {
            System.out.println("NO");
        }
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                prime = false;
                System.out.println("NO");
                break;
            }
        }
        if (prime) {
            System.out.println("YES");
        }

    }

}

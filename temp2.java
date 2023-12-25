import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class temp2 {

    public static void main(String[] args) {
        //        isPrime();
        //        isPerfectNum();
//        System.out.println(isPerfectSquare(144));
        armstrongNum(500);
    }

    public static void isPrime() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        boolean prime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        System.out.println(prime ? "YES" : "NO");
    }

    public static void isPerfectNum() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; i++) {
            int num = scn.nextInt();
            isPerfectNumHelper(num);
        }
        scn.close();
    }

    public static void isPerfectNumHelper(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        int sum = divisors.stream().reduce(0, Integer::sum);
        System.out.println(sum == n ? "YES" : "NO");
    }

    public static int isPerfectSquare(int n) {
        int ans = -1;
        for (int i = 2; i * i <= n; i++) {
            if (i * i == n) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void armstrongNum(int n){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for(int i = 2; i<=n; i++){
            if(i == 153){
                System.out.println("Pause");
            }
            int num = i;
            System.out.println(i);
            ArrayList<Integer> digits = new ArrayList<>();
            while (num!=0){
                digits.add(num%10);
                num = num/10;
            }
            Double sum = digits.stream().map(t -> Math.pow(t, 3)).collect(Collectors.toList()).stream().reduce(0.0, Double::sum);
            if(sum.intValue() == i)
                list.add(i);
        }
        list.stream().forEach(System.out::println);
    }
}

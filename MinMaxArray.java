import java.util.Scanner;

public class MinMaxArray {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scn.nextInt();
        }
        scn.nextLine();
        scn.close();

        int min = 0, max = 0;
        if (A.length != 0) {
            min = A[0];
            max = A[0];
        }
        for (int i = 1; i < N; i++) {
            if (A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
        }

        System.out.println(max + " " + min);

    }

}

import java.util.Scanner;

public class SearchElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for (int i = 0; i < T; i++) {
            int len = scn.nextInt();
            int[] A = new int[len];
            for (int j = 0; j < len; j++) {
                A[j] = scn.nextInt();
            }
            scn.nextLine();
            int B = scn.nextInt();
            System.out.println(searchElem(A, B));
        }
        scn.close();
    }

    static int searchElem(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B) {
                return 1;
            }
        }
        return 0;
    }

}

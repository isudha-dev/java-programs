package twodarray;

public class SpiralMatrix2 {

    public static void main(String[] args) {

        int A = 5;
        int n = A;
        int i = 0, j = 0;
        int num = 1;
        int[][] arr = new int[A][A];
        if (n == 0) {
            arr[0][0] = A;
        }
        while (n > 1) {
            for (int k = 1; k < n; k++) {
                arr[i][j] = num;
                num++;
                j++;
            }
            for (int k = 1; k < n; k++) {
                arr[i][j] = num;
                num++;
                i++;
            }
            for (int k = 1; k < n; k++) {
                arr[i][j] = num;
                num++;
                j--;
            }
            for (int k = 1; k < n; k++) {
                arr[i][j] = num;
                num++;
                i--;
            }
            n = n - 2;
            i++;
            j++;
        }
        if (n % 2 != 0) {
            arr[i][j] = num;
        }

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                System.out.print(arr[x][y] + "  ");
            }
            System.out.println();
        }

    }

}

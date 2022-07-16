package modulo;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {
        arrange(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 4, 3, 0, 2 })));
    }

    static void arrange(ArrayList<Integer> a) {
        int n = a.size();
        // step 1: A[i] = A[i] * n
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) * n);
        }

        // step 2: A[i] = A[i] + A[A[i]/n]/n
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) + a.get(a.get(i) / n) / n);
        }

        // step 3: A[i] = A[i] % n
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) % n);
        }

        System.out.println(a);

    }

}

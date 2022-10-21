package greedy;

import java.util.ArrayList;

public class Seats {

    public static void main(String[] args) {
        Seats s = new Seats();
        s.seats("x...x..xx...x..");
    }

    int seats(String A) {
        long res = 0;
        int mod = 10000003;
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x')
                pos.add(i);
        }
        int m = pos.size();
        int mid = m / 2;
        int left = mid - 1, right = mid + 1, k = 1;
        while (left >= 0) {
            res = res + (pos.get(mid) - k - pos.get(left)) % mod;
            --left;
            ++k;
        }
        k = 1;
        while (right < m) {
            res = res + (pos.get(right) - pos.get(mid) - k) % mod;
            ++right;
            ++k;
        }

        return (int) (res % mod);
    }

}

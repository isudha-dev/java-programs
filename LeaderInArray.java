import java.util.ArrayList;

public class LeaderInArray {

    public static void main(String[] args) {
        solve(new int[] { 16, 17, 4, 3, 5, 2 });
    }

    static int[] solve(int[] A) {
        int n = A.length;
        int leader = A[n - 1];

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(leader);

        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > leader) {
                leader = A[i];
                ans.add(A[i]);
            }
        }

        int[] arr = ans.stream().mapToInt(i -> i).toArray();
        return arr;
    }

}

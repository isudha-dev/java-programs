import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOp {

    public static void main(String[] args) {

        System.out.println(buildArray(new int[] { 2, 3, 5 }, 4));
    }

    static List<String> buildArray(int[] target, int n) {

        ArrayList<String> ans = new ArrayList<String>();

        int i = 1, j = 0;
        while (j < target.length && i <= n) {
            if (target[j] == i) {
                ans.add("Push");
                i++;
            } else if (target[j] > i) {
                ans.add("Push");
                ans.add("Pop");
                i++;
                continue;
            }
            j++;
        }

        return ans;
    }

}

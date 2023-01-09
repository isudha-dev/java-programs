public class MinimumDistance_Q1 {

    public static void main(String args[]) {

        String str = "x...o.x...o";
        System.out.println(solve(str));

    }

    static int solve(String A) {

        int last_x = -1;
        int last_o = -1;
        int ans = (int) Double.POSITIVE_INFINITY;
        char ch[] = A.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'x') {
                last_x = i;
                if (last_o != -1) {
                    ans = Math.min(ans, Math.abs(last_x - last_o));
                }
            }
            if (ch[i] == 'o') {
                last_o = i;
                if (last_x != -1) {
                    ans = Math.min(ans, Math.abs(last_x - last_o));
                }
            }
        }
        if (ans == (int) Double.POSITIVE_INFINITY) {
            ans = -1;
        }
        return ans;
    }

    static int solve1(String A) {
        char start = 'n';
        char end = 'n';

        char str[] = A.toCharArray();
        int j = 0;
        int min = 0;
        boolean initialized = false;

        for (int k = 0; k < str.length; k++) {

            if (initialized) {
                if (str[k] == start) {
                    j = 0;

                } else if (str[k] == end) {
                    j++;
                    if (j < min || min == 0) {
                        min = j;
                    }
                    char temp = start;
                    start = end;
                    end = temp;
                    j = 0;
                } else {
                    j++;
                }
            } else {
                if (str[k] == 'x' || str[k] == 'o') {
                    start = str[k] == 'x' ? 'x' : 'o';
                    end = str[k] == 'x' ? 'o' : 'x';
                    initialized = true;
                }
            }
        }

        return (min == 0) ? -1 : min;
    }

}

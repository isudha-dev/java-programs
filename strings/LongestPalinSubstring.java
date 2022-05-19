package strings;

public class LongestPalinSubstring {

    public static void main(String[] args) {

        System.out.println(maxPalinSubstring("gyzxabcbaxzygvjkfkcyttyckftf"));

    }

    static int maxPalinSubstring(String str) {
        int n = str.length();
        int ans = 1;

        // for odd length substring
        for (int i = 0; i < n; i++) {
            int p1 = i, p2 = i;
            ans = Math.max(ans, expandAndFindLen(str, p1, p2));
        }

        // for even length substring
        for (int i = 0; i < n - 1; i++) {
            int p1 = i, p2 = i + 1;
            ans = Math.max(ans, expandAndFindLen(str, p1, p2));
        }
        return ans;
    }

    static int expandAndFindLen(String str, int p1, int p2) {
        char[] chStr = str.toCharArray();
        while (p1 >= 0 && p2 < str.length()) {
            if (chStr[p1] != chStr[p2]) {
                break;
            }
            p1--;
            p2++;
        }
        return p2 - p1 - 1;
    }

}

// TC: O(N^2)

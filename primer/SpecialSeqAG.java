package primer;

public class SpecialSeqAG {

    public static void main(String[] args) {
        System.out.println(solve("AGBGAAGA"));
    }

    static int solve(String A) {

        int countA = 0;
        int ans = 0;
        for (char ch : A.toCharArray()) {
            if (ch == 'A') {
                countA++;
            }
            if (ch == 'G') {
                ans += countA;
            }

        }

        return ans;
    }
}

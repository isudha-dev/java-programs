package dsa.subsequence_subsets;

public class FindSubseq {
    public static void main(String[] args) {
        System.out.println(solve("biy", "dfbkjijgbbiihbmmt"));
    }

    static String solve(String A, String B) {

        if (A.length() > B.length()) {
            return "NO";
        } else if (A.length() == B.length() && A.equals(B)) {
            return "YES";
        } else {
            int idxA = 0;
            for (int i = 0; i < B.length(); i++) {
                if (B.charAt(i) == A.charAt(idxA)) {
                    idxA++;
                }
                if (idxA == A.length()) {
                    return "YES";
                }
            }
        }

        return "NO";

    }

}

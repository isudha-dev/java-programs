package subsequence_subsets;

public class LexicographicSubseq {

    public static void main(String[] args) {
        System.out.println(solve("ksdjgha"));
    }

    static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = A.toCharArray();
        int idxMinVal = 0;
        int minVal = chArr[0];
        for (int i = 1; i < chArr.length - 1; i++) {
            if (chArr[i] < minVal) {
                minVal = chArr[i];
                idxMinVal = i;
            }
        }
        String temp = Character.toString(chArr[idxMinVal]);
        sb.append(temp);

        idxMinVal++;
        minVal = chArr[idxMinVal];

        for (int i = idxMinVal + 1; i < chArr.length; i++) {
            if (chArr[i] <= minVal) {
                minVal = chArr[i];
                idxMinVal = i;
            }
        }

        temp = Character.toString(chArr[idxMinVal]);
        sb.append(temp);

        return sb.toString();
    }

}

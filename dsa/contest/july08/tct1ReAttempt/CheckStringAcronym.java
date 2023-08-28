package dsa.contest.july08.tct1ReAttempt;

public class CheckStringAcronym {
    public static int solve(String[] A, String B) {
        int n = A.length;
        if(A.length == 0 || B.length() == 0){
            return 0;
        }
        if(A.length != B.length()){
            return 0;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String str = A[i];
            sb.append(str.charAt(0));
        }

        return sb.toString().equals(B) ? 1: 0;
    }

    public static void main(String[] args) {
        System.out.println(solve(new String[] {"cpp","defg","ghi"}, ""));
    }


}

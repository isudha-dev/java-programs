package greedy;

public class AnotherCoinProb {

    public static void main(String[] args) {

        // System.out.println((int) (Math.log(22) / Math.log(5)));
        AnotherCoinProb ac = new AnotherCoinProb();
        System.out.println(ac.solve(9));
    }

    public int solve(int A) {
        int minCoin = 0;

        while (A > 0) {
            int expo = (int) (Math.log(A) / Math.log(5));
            int minVal = (int) Math.pow(5, expo);
            A = A - minVal;
            minCoin++;
        }

        return minCoin;
    }

}

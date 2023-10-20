package dsa.arrays;

public class JosephsKilling {

    public static void main(String[] args) {
        int num = 50;
        int temp = num;

        // find left most set bit
        int count = 0;
        while(num > 0){
            count++;
            num = num >> 1;
        }

        int calc2Pow = 1;
        for(int i = 1; i< count; i++){
            calc2Pow *= 2;
        }

        int t = temp - calc2Pow;


        int ans = t*2+1;
        System.out.println(ans);

        // 1100100 = 64+32+4

    }

}

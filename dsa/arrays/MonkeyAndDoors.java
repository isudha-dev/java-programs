package dsa.arrays;

public class MonkeyAndDoors {

    public static void main(String[] args) {
        int n = 121;
        int count=0;
        for(int i = 1; i*i <= n; i++){
            count++;
        }
        System.out.println( count);
    }

}

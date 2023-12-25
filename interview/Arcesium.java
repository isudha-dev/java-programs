package interview;

public class Arcesium {

    /*
    Questions:
    Wierd stock
    Product
    Hydrate the nodes
     */

    public static void main(String[] args) {
        System.out.println(stock(5, 15));
    }

    public static int stock(int n, int m){
        int ans = 0;
        if(n > m){
            return n-m;
        } else {
            while(n < m) {
                if(m%2 == 0){
                    ans++;
                    m = m/2;
                } else {
                    ans++;
                    m = m+1;
                }
            }
            ans += (n-m);

        }
        return ans;
    }

}

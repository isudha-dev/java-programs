package interview;

public interface Razorpay extends JPMorgan, SalesforceHR{

    public static void main(String[] args) {
        System.out.println(count(800000000));
//        System.out.println(prime(17));
//        System.out.println(magic(4, new int[]{1,2,3,4}, new int[] {1,2,3,4,}));
    }

    /*
        7
     */

    public static long count(long n){
        long res = 0;
        long mod = 1000000007;
        n = n % mod;

        for(int i = 1; i<=n ; i++){
            i = (int) (i%mod);
            res = (res + ((i%mod) * (i%mod))) % mod;
        }

        return res;
    }

    public static String prime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0){
                return "No";
            }
        }
        if(n%4 == 1){
            return "YES";
        }

        return "NO";
    }

    static int magic(int n, int[] a, int[] b){
        int result = 0;
        int mod = 1000000007;

        for(int i = 0; i< n; i++){
            int mul = ((a[i]%mod)*(b[i]%mod))%mod ;
            int div = mul/2;
            if(div == 0){
                div = 1;
            }

            result = (result + div)%mod;

        }

        return result;
    }

    static long division(long a, long b, long c){
        long result = 0;
        if(c<=b){
            return -1;
        }
        long i = a*b;
        for(long j = i; j<c; j++){
            if(j%a == b){
                return j;
            }
        }
        return result;
    }


}

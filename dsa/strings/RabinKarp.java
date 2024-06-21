package dsa.strings;

public class RabinKarp {
    public static void main(String[] args) {
        System.out.println(findPattern("aaaaaaaaa", "aaa"));
    }

    public static boolean findPattern(String t, String s){
        int n = t.length();
        int m = s.length();
        int mod = 1000000007;
        int k = 26;
        int[] powK = new int[m];
        powK[0] = 1;
        for (int i = 1; i < m; i++) {
            powK[i] = (powK[i-1] * k) % mod;
        }

        int hashT = 0, hashS = 0;
        for (int i = 0; i < m; i++) {
            hashT = (hashT + (t.charAt(i) * powK[m-i-1]) % mod) % mod;
            hashS = (hashS + (s.charAt(i) * powK[m-i-1]) % mod) % mod;
        }

        if(hashT == hashS && t.substring(0, m).equals(s)){
            return true;
        }

        for(int i = m; i < n; i++){
            hashT = (hashT - t.charAt(i-m)*powK[m-1] + mod ) % mod;
            hashT = (hashT * k) % mod;
            hashT = hashT + t.charAt(i);

            if(hashT == hashS && t.substring(i-m+1, i+1).equals(s)){
                return true;
            }
        }

        return false;
    }
}

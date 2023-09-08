package interview;

public class JPMorgan {

    public static void main(String[] args) {
        System.out.println(breakPalindrome("aaa"));
    }

    public static String breakPalindrome(String palindromeStr) {
        // Write your code here

        int n = palindromeStr.length();
        // change each char of string starting from 0 -> n-1
        for(int i = 0; i< n; i++){
            char[] chArr = palindromeStr.toCharArray();
            int charPos = chArr[i];

            // for each change try all char from a to char-1
            for(int j = 97; j < charPos; j++){
                chArr[i] = (char) j;

                // for each outcome, ensure its not palindrome
                boolean isPalin = isPalindrome(new String(chArr), n);
                if(!isPalin){
                    return new String(chArr);
                }
            }

        }
        return "IMPOSSIBLE";
    }

    public static boolean isPalindrome(String s, int n){
        int mid = n/2;

        if(n%2 != 0){
            // odd len
            int p1 = mid -1;
            int p2 = mid +1;
            while (p1 >= 0 && p2 <n){
                if(s.charAt(p1) != s.charAt(p2)){
                    return false;
                }
                p1--;
                p2++;
            }
        } else {
            // even len
            int p1 = mid-1;
            int p2 = mid;
            while (p1 >= 0 && p2 <n){
                if(s.charAt(p1) != s.charAt(p2)){
                    return false;
                }
                p1--;
                p2++;
            }
        }



        return true;
    }

}

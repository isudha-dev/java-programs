package interview;

public interface JPMorgan {

    public static void main(String[] args) {
//        System.out.println(breakPalindrome("aaa"));
        System.out.println(lotteryTicketWinner(90));
    }

    public static String breakPalindrome(String palindromeStr) {
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

    public static int lotteryTicketWinner(int n){
        // n in range 1 - 10^4
        int[] arr = new int[37];
        for(int i = 1; i<=n; i++){
            int sum = sumOfNum(i);
            arr[sum] += 1;
        }

        int max = Integer.MIN_VALUE;
            for(int i: arr){
            max = Math.max(max, i);
        }
        return max;

    }

    public static int sumOfNum(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }

}

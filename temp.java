import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class temp {

    public static void main(String[] args) {
//        String A = "aaaabaaa";
//        System.out.println(longestPalindrome(A));

//        String[] A = {"abab", "ab", "abcd"};
//        System.out.println( solve(A));

//        titleToNumberExcel("9216");

//        System.out.println(findMod("9216", 25));
//        System.out.println(repeatedNumber(new ArrayList<>(Arrays.asList(new Integer[] {3,1,2,5,3}))));
//        System.out.println( solve(33, 33, 33));
//        System.out.println(Math.floor(5/2));
//        System.out.println(sortingBasedOnFactors(new ArrayList<>(Arrays.asList(new Integer[] {9,3,4,8,16,37,6,13,15}))));
//        System.out.println(factor(100));

//        reverseSentence("this is me, sudha");
//        to_lower(new ArrayList<>(Arrays.asList(new Character[] {'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'})));
        System.out.println(longestCommonPrefix(new String[] {"abcd","abcd","efgh"}));

    }

    /*
    abcd - 4
    a - 0
    ab
    abc
    abcd

    abedce
    a -> 6 - 0 = 6
    e = 6 - 2 = 4
    e = 6 - 6 = 0
     */

    public static String longestCommonPrefix(String[] A) {
        int i = -1;
        int minLen = Integer.MAX_VALUE;
        for(String s: A){
            minLen = Math.min(minLen, s.length());
        }

        for(int j = 0; j< minLen; j++){
            char c = A[0].charAt(j);
            boolean matchFlag = true;
            for(String s: A){
                if(s.charAt(j) != c){
                    matchFlag = false;
                    break;
                }
            }
            if(matchFlag){
                i = j;
            } else {
                break;
            }

        }

        if(i == -1) return "";
        return A[0].substring(0, i+1);

    }

    public static int changeChar(String A, int B){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: A.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for(int i = 0; i<list.size(); i++){
            B -= list.get(i);
            if(B<0){
                return list.size()-i;
            }
        }
        return list.size();

    }

    public static int countOccurrence(String A) {
        int count = 0;
        int n = A.length();
        int i = 0;
        while(i < n-2){
            if(A.substring(i, i+3).equals("bob")){
                count++;
                i=i+2;
            } else {
                i++;
            }
        }
        return count;
    }

    public static String longestPalindrome(String str) {
        int n = str.length();
        int startIdx = 0;
        int endIdx = 0;
        int currLen = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            // odd
            int p1 = i-1;
            int p2 = i+1;
            while(p1>=0 && p2<n){
                if(str.charAt(p1) != str.charAt(p2)){
                    break;
                } else {
                    currLen = p2-p1+1;
                    if(currLen > maxLen){
                        maxLen = currLen;
                        startIdx = p1;
                        endIdx = p2;
                    }
                    p1--;
                    p2++;
                }

            }

            // even
            p1 = i-1;
            p2 = i;
            while(p1>=0 && p2<n){
                if(str.charAt(p1) != str.charAt(p2)){
                    break;
                } else {
                    currLen = p2-p1+1;
                    if(currLen > maxLen){
                        maxLen = currLen;
                        startIdx = p1;
                        endIdx = p2;
                    }
                    p1--;
                    p2++;
                }

            }
        }

        return str.substring(startIdx, endIdx+1);

    }

    public static ArrayList<Character> to_lower(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i) >= 'A' && A.get(i) <= 'Z')
                A.set(i,(char) (A.get(i) ^ (1<<5)));
        }
        return A;
    }


    public static char[] reverseString(char[] A, int l, int r){
        while (l<r){
            char temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
        return A;
    }

    public static String reverseSentence(String A){
        ArrayList<String> arr = new ArrayList<>();
        int n = A.length();

        int p1 = 0, p2 = 0;
        while(p2 < n){
            while (p2<n && A.charAt(p2) != ' '){
                p2++;
            }
            arr.add(A.substring(p1, p2));
            while (p2<n && A.charAt(p2) == ' '){
                p2++;
            }
            p1 = p2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = arr.size()-1; i>=0; i--){
            sb.append(arr.get(i)).append(" ");
        }

        return sb.toString();

    }

    public static ArrayList<Integer> sortingBasedOnFactors(ArrayList<Integer> A){
        ArrayList<Integer> factorsA = new ArrayList<>();
        for(int i: A){
            factorsA.add(factor(i));
        }

        A.sort((o1, o2) -> {
            int f1 = factor(o1);
            int f2 = factor(o2);
            if(f1<f2){
                return -1;
            } else if (f2 < f1){
                return 1;
            } else {
                return o1-o2;
            }
        });


        return A;
    }

    public static int factor(int A){
        int count = 0;
        for(int i = 1; i*i<=A; i++){
            if(A%i == 0){
                if(i*i == A){
                    count++;
                } else {
                    count=count+2;
                }
            }
        }
        return count;
    }

    public static String largestNumber(final ArrayList<Integer> A) {
        Comparator<Integer> comparator = (o1, o2) -> {
            String s1 = o1+""+o2;
            String s2 = o2+""+o1;
            return s1.compareTo(s2);
        };

        A.sort((o1, o2) -> {
            String s1 = o1+""+o2;
            String s2 = o2+""+o1;
            return s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<A.size(); i++){
            sb.append(A.get(i));
        }
        if(sb.charAt(0) == 0){
            return "0";
        }

        return sb.toString();
    }

    public static int nobelInteger(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for(int i = 0; i< n; i++){
            if(A[i] == A[i+1]){
                continue;
            } else if(A[i] == n-i-1){
                return 1;
            }
        }
        return -1;
    }

    public static int[] sortColors(int[] A) {
        int zeroIdx = 0;
        int twoIdx = A.length - 1;

        for(int i = 0; i<= twoIdx;){
            if(A[i] == 0){
                int temp = A[zeroIdx];
                A[zeroIdx] = A[i];
                A[i] = temp;
                zeroIdx++;
                i++;
            } else if(A[i] == 2){
                int temp = A[twoIdx];
                A[twoIdx] = A[i];
                A[i] = temp;
                twoIdx--;
            } else {
                i++;
            }
        }

        return A;
    }

    public static int magicNum(int A) {
        int ans = 0;
        int res = 5;
        while (A>0){
            if((A & 1) == 1){
                ans = ans + res;
            }
            res *= 5;
            A = A>>1;
        }

        return ans;
    }

    public static int majorityElement1(final int[] A) {
        int n = A.length;
        int maj = A[0];
        int count = 1;

        for(int i = 1; i<n; i++){
            if(A[i] == maj)
                count++;
            else if(count == 0)
                maj = A[i];
            else
                count++;
        }
        count = 0;

        for(int i = 0; i<n; i++){
            if(A[i] == maj)
                count++;
        }

        return count > n/2 ? maj : -1;
    }

    public static int repeatedNumber1(int[] A) {
        int n = A.length;
        if(n == 1) return A[0];
        // if(n == 2) return (A[0] == A[1] ? A[0] : -1);
        int cnt1 = 1;
        int cnt2 = 1;

        int maj1 = A[0];
        int maj2 = A[1];

        if(maj1 == maj2) {
            cnt1 = 2;
            cnt2 = 0;
        }

        int startIdx = 2;
        while(startIdx < n && maj1 == maj2 ){
            if(maj1 == A[startIdx]) {
                cnt1++;
            } else {
                maj2 = A[startIdx];
                cnt2++;
            }
            startIdx++;
        }

        for(int i = startIdx; i < A.length; i++){
            int elem = A[i];
            if(cnt1 == 0){
                maj1 = elem;
                cnt1++;
            } else if (cnt2 == 0){
                maj2 = elem;
                cnt2++;
            } else if(A[i] == maj1){
                cnt1++;
            } else if (A[i] == maj2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i< n; i++){
            if(A[i] == maj1) cnt1++;
            if(A[i] == maj2) cnt2++;
        }

        if(cnt1 > (n/3)) return maj1;
        if(cnt2 > (n/3)) return maj2;
        return -1;
    }

    public static int majorityElement1final (List<Integer> A) {
        if (A == null)
            return -1;
        int maj = A.get(0);
        int count = 1;
        int n = A.size();
        for (int i = 1; i < n; i++) {
            if (A.get(i) == maj) {
                count++;
            } else if (count == 1) {
                maj = A.get(i);
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) == maj)
                count++;
        }
        if (count > n / 2)
            return maj;
        return -1;
    }

    public static int majorityElement(final int[] A) {
        double n = A.length;
        double count1 = n/2.0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap();
        for(int i: A){
            if(!(map.containsKey(i))){
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
            if(map.get(i) > count1){
                ans = i;
                break;
            }
        }
        return ans;

    }
    public int josephsProblem(int N){
        // N = 2^k+ t => ans will be 2t+1
        // t = N - 2^k

        // find left most set bit to get value of k
        int k = 0;
        while(N > 0){
            k++;
            N = N>>1;
        }

        k-- ; // bit starts from 0 to k
        // calculate 2^k
        int value = 1;
        for(int i = 0; i<k; i++){
            value *=2;
        }

        //calculate N-2^k
        int t = N - value;

        return 2*t+1;
    }

    public static int solve(int A, int B, int C) {
        int min1 = 0, min2 = 0, min3 = 0;

        if(A < B && A < C) {
            min1 = A;
            if(B < C){
                min2 = B;
                min3 = C;
            } else {
                min2 = C;
                min3 = B;
            }
        } else if (B < C && B < A) {
            min1 = B;
            if(A < C){
                min2 = A;
                min3 = C;
            } else {
                min2 = C;
                min3 = A;
            }
        } else if (C < B && C < A) {
            min1 = C;
            if(B < A){
                min2 = B;
                min3 = A;
            } else {
                min2 = A;
                min3 = B;
            }
        }

         if(min1 == 0 || min2 == 0 || min3 == 0){
             if(A == B) {
                 if (A < C) {
                     min1 = A;
                     min2 = B;
                     min3 = C;
                 } else {
                     min1 = C;
                     min2 = A;
                     min3 = B;
                 }
             } else if (A == C) {
                 if (A < B) {
                     min1 = A;
                     min2 = C;
                     min3 = B;
                 } else {
                     min1 = B;
                     min2 = A;
                     min3 = C;
                 }
             } else if (B == C){
                 if (B < A) {
                     min1 = B;
                     min2 = C;
                     min3 = A;
                 } else {
                     min1 = A;
                     min2 = B;
                     min3 = C;
                 }
             }
         }

        if(min1 == 0 || min2 == 0 || min3 == 0){
            if(A == B && B == C){
                min1 = A;
                min2 = B;
                min3 = C;
            }
        }

        int ans = min1 * 10000 + min2 * 100 + min3;
        return ans;
    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int rep = 0, miss;

        long sumActual = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i<A.size(); i++){
            if(!set.contains(A.get(i))){
                set.add(A.get(i));
            } else {
                rep = A.get(i);
            }
            sumActual += (long) A.get(i);
        }

        long n = A.size();
        long sumExpected = (n * (n+1)) / 2;
        miss = (int) (sumExpected - sumActual + (long) rep);

        return new ArrayList<>(Arrays.asList(new Integer[] {rep, miss}));
    }

    public static ArrayList<Integer> repeatedNumber1(ArrayList<Integer> A) {

        ArrayList<Integer> res = new ArrayList<>();

        Collections.sort(A);
        int n = A.size();
        int rep = -1;
        int miss = -1;
        long sum = A.get(0);

        for (int i = 1; i < n; i++) {
            if (A.get(i).intValue() == A.get(i - 1).intValue()) {
                rep = A.get(i);
            }
            sum += A.get(i);
        }

        miss = (int) ((1L * n * (1L * n + 1)) / 2 - sum + rep);

        res.add(rep);
        res.add(miss);

        return res;

    }

    public static int findMod(String A, int B) {
        long ans = 0;
        int n = A.length();
        int r = 1;
        for(int i = n-1; i>=0; i--){
            ans = ans + ( (long) (((A.charAt(i) - '0') % B) * (r % B)) % B);
            r = (r * 10%B) % B;

        }
        return (int) ans;
    }

    static int pow(int a, int n, int p){
        long ans = 1;
        for(int i = 0; i<n; i++){
            ans= (ans * a%p) % p;
        }
        return (int) ans;
    }

    public static int titleToNumberExcel(String A){
        int n = A.length();
        if(n == 1){
            return (A.charAt(0)-'0') % 8 == 0 ? 1 : 0;
        } else if(n == 2) {
            int num = (A.charAt(1)-'0') + (A.charAt(0)-'0') * 10 ;
            return num % 8 == 0 ? 1 : 0;
        } else {
            int num = (A.charAt(n-3)-'0') * 100 + (A.charAt(n-2)-'0') * 10 + (A.charAt(n-1)-'0');
            return num % 8 == 0 ? 1 : 0;
        }
    }



    public static String solve(String A[]) {
       int minLen = Integer.MAX_VALUE;
       for(String a: A){
           minLen = Math.min(minLen, a.length());
       }
       boolean flag = false;
       int endIdx = -1;
       for(int i = 0; i< minLen; i++){
           flag = true;
           char c = A[0].charAt(i);
           for(int j = 1; j< A.length; j++){
               if(A[j].charAt(i) != c){
                   flag = false;
                   break;
               }
           }
           if(!flag){
               break;
           }
           endIdx++;
       }

       if(endIdx == -1)
           return "";

       return A[0].substring(0, endIdx+1);

    }

    String reverseString(String A){
        char[] chArr = A.toCharArray();
        reverse(chArr, 0, chArr.length);

        int i = 0, j = 0;
        while(i < chArr.length){
            while (chArr[j] != ' '){
                j++;
                if(j == chArr.length){
                    break;
                }
            }
            reverse(chArr, i, j);
            i=j+1;
            j=i;
        }
        return String.valueOf(chArr).trim();
    }

    char[] reverse(char[] chArr, int start, int end){
        int i = start, j = end-1;
        while(i<j){
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            i++;
            j--;
        }

        return chArr;
    }

}

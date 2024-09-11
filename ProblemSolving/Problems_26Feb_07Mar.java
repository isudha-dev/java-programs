package ProblemSolving;

import dsa.gcd.Pubg;

import java.math.BigInteger;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problems_26Feb_07Mar {
    public static void main(String[] args) {
//        intersect(new ArrayList<>(Arrays.asList(2, 3, 3, 4, 4, 6, 8, 8, 9, 9, 10, 10, 11, 14, 14, 15, 16, 18, 20, 21, 23, 23, 24, 25, 28, 29, 33, 33, 35, 35, 37, 38, 38, 40, 41, 42, 42, 44, 44, 47, 47, 49, 49, 52, 53, 56, 58, 61, 62, 62, 63, 64, 65, 65, 66, 67, 67, 67, 68, 69, 72, 74, 76, 76, 79, 80, 82, 82, 83, 83, 83, 84, 85, 85, 85, 85, 87, 91, 93, 94, 94, 94, 95, 96, 101, 101)),
//                new ArrayList<>(Arrays.asList(12, 12, 20, 39, 42, 44, 47, 73, 77))).forEach(System.out::println);

//        countRectangle(new ArrayList<>(Arrays.asList(1,1,2,2)), new ArrayList<>(Arrays.asList(1,2,1,2)));

//        pointsInLine(new ArrayList<>(Arrays.asList(0,-3,-6,0,-7,0,2,0,5)),
//                new ArrayList<>(Arrays.asList(-9,-7,-8,-4,-3,0,-9,-3,7)));
//        goodSubarrays(new ArrayList<>(Arrays.asList(5, 15, 1, 5, 5, 5, 8, 13, 3, 4, 7, 16, 15, 9, 4, 5, 9)), 1);
        // failing for this case because all element will contribute 16 sub arrays and then 5,5 will add 1 more
        // hence total 17
        // https://www.interviewbit.com/problems/subarrays-with-distinct-integers/
//        vowelConsonantSubs("ansdsaiacodfu");
//        numToWords("2167", "two-thousand-one-hundred-and-sixty-seven");
//        String A = "mxxxzclaql10~omttepvukq10~sckhqgagqt10~miaufqvumh10~jndrqnllah10~wqlithzmfi10~oczafaqcrz10~lnubllvcsq10~rzngzhllmw10~ntpvbeyxnk10~";
//        ArrayList<String> s = deserializeString(A);
//        s.forEach(System.out::println);

//        System.out.println(StringFreq("abbhuabcfghh"));
//        System.out.println(bullsCows("18078", "78108"));
//        System.out.println(permuteStrings("scaaler", "leraasc"));
//        System.out.println(longestCommonPrefix(new ArrayList<>(Arrays.asList("abcdefgh", "abcfghijk", "abcefgh"))));
//        System.out.println(countAndSay(7));
//        System.out.println(amazingSubstring("ABEC"));
//        System.out.println(strStr("bbbbbbbbab", "baba"));
//        System.out.println(minParentheses(")("));
//        System.out.println(printAlternate("hello", "world"));
//        System.out.println(countSalutes("<>"));
//        System.out.println(reverseStringByWords("qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo"));
//        System.out.println(isPalindrome("oqycntornscygodzdctxnhnxtcdzdogycsnrotncyqo"));
//        System.out.println(minPalindrome("abeede"));
//        System.out.println(compareVersion("1.0", "1"));
//        System.out.println(zigzagString("MYNAMEISSUDHA",4));
//        System.out.println(atoi("54332872018247709407"));
//        System.out.println(firstNonRepeatingChar("abadbc"));
//        System.out.println(maxSpecialProduct(new ArrayList<>(Arrays.asList(6, 7, 9, 5, 5, 8))));
        System.out.println(braces("(a*(b+c)*(d+e)*(a+c))"));
    }

    public static int braces(String A) {
        // (d*(a+b)+c)*(d)*a+(b+c)
        Stack<Character> stk = new Stack();
        for(Character c: A.toCharArray()){
            if(c == '+' || c == '-' || c == '*' || c == '/' || c == '('){
                stk.push(c);
            }
            if(c == ')' && !stk.isEmpty()) {
                Character k = stk.peek();
                if (k == '(') {
                    return 1;
                }

                if (k != '+' && k != '-' && k != '*' && k != '/') {
                    return 1;
                }
                while (!stk.isEmpty() && (k == '+' || k == '-' || k == '*' || k == '/')){
                    stk.pop();
                    k = stk.peek();
                }

                if(k != '('){
                    return 1;
                } else {
                    stk.pop();
                }
            }
        }
        while (!stk.isEmpty()){
            Character c = stk.peek();
            if(c == '+' || c == '-' || c == '*' || c == '/' || c == '('){
                stk.pop();
            }
        }

        if(stk.isEmpty()){
            return 0;
        } else {
            return 1;
        }
    }

    public static int maxSpecialProduct(ArrayList<Integer> A) {
       /*
       1,4,2,3,6,4,2
       0,1,2,3,4,5,6
       -1,-1,1,1,-1,4,5
       1,4,3,4,-1,-1,-1
       0,0,3,4,0,0,0

       6, 7, 9, 5, 5, 8
       0, 1, 2, 3, 4, 5
       0, 0, 0, 2, 2, 2
       1, 2, 0, 5, 5, 0
       0, 0, 0, 10, 10, 0

       */
        int n = A.size();
        ArrayList<Integer> left = new ArrayList<>();
        Stack<Integer> sA = new Stack<>();

        for(int i = 0; i < n; i++){
            while (!sA.isEmpty() && A.get(i) >= A.get(sA.peek())){
                sA.pop();
            }
            if(sA.isEmpty()){
                left.add(0);
            } else {
                left.add(sA.peek());
            }
            sA.push(i);

        }

        ArrayList<Integer> right = new ArrayList<>();
        sA = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while (!sA.isEmpty() && A.get(i) >= A.get(sA.peek())){
                sA.pop();
            }
            if(sA.isEmpty()){
                right.add(0,0);
            } else {
                right.add(0, sA.peek());
            }
            sA.push(i);

        }

        int maxVal = Integer.MIN_VALUE;
        int mod = 1000000007;

        for(int i = 0; i<n; i++){
            long prod = ((long) left.get(i) * (long) right.get(i)) % (long) mod;
            maxVal = Math.max(maxVal, (int) prod);
        }

        return maxVal;
    }

    public static String firstNonRepeatingChar(String A) {
        /*
        abadbc -> aabbdd
        abcabc -> aaabc#
         */

        StringBuilder ans=new StringBuilder();
        Map<Character,Integer> map=new HashMap<>();
        Queue<Character> q=new LinkedList<>();
        for(char ch:A.toCharArray()){
            if(q.contains(ch)){
                map.put(ch,1);
                q.remove(ch);
                if(q.isEmpty()){
                    ans.append('#');
                }else{
                    ans.append(q.peek());
                }
            } else{
                if(!map.containsKey(ch)){
                    q.add(ch);
                }
                if(q.isEmpty()){
                    ans.append('#');
                }else{
                    ans.append(q.peek());
                }
            }
        }
        return ans.toString();


    }

    public static ArrayList<String> restoreIpAddresses(String A) {

        /*
            25525511135
            1st digit can not start with >2

         */


        return null;
    }

    public static int atoi(final String A) {
        String s = A.trim();
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean isNeg = false;

        String c = arr[0];
        for(int i = 0; i<c.length(); i++){
            char ch = c.charAt(i);
            if(ch ==  '-' && i == 0){
                isNeg = true;
                continue;
            }
            if(ch == '+' && i == 0){
                continue;
            }
            if(ch >= 48 && ch <= 57){
                sb.append(ch);
            } else {
                break;
            }
        }
        if(sb.length() == 0)
            return 0;

        try {
            int i = Integer.parseInt(sb.toString());
            if (isNeg)
                return -i;
            else
                return i;
        } catch (NumberFormatException e){
            if(isNeg)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }

    }

    public String addBinary(String A, String B) {
        int carry= 0;
        int i = A.length()-1, j = B.length()-1;
        StringBuilder sb = new StringBuilder();
        while (carry != 0 && A.charAt(i) != 0 && B.charAt(j) != 0){
            int sum = 0;
            sum += carry;

        }



        return "";
    }

    public static String zigzagString(String A, int B){
        List<List<Character>> list = new ArrayList<>();
        IntStream.range(0, B).forEach(i -> list.add(new ArrayList<>()));
        int len = A.length();
        int k = 0;
        while (k < len) {
            int i = 1;
            while (k < len && i <= B) {
                list.get(i-1).add(A.charAt(k));
                k++;
                i++;
            }
            int j = B - 1;
            while (k < len && j >= 2) {
                list.get(j-1).add(A.charAt(k));
                k++;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<B; i++){
            list.get(i).forEach(s -> sb.append(s));
        }
        return sb.toString();
    }

    public static int compareVersion(String A, String B) {
//        if(!A.contains(".") && !B.contains(".")){
//            return Long.compare(Long.parseLong(A), Long.parseLong(B));
//        }
//
//        if(!A.contains(".")){
//            return Long.compare(Long.parseLong(A), Long.parseLong(B.split("\\.")[0]));
//        }
//
//        if(!B.contains(".")){
//            return Long.compare(Long.parseLong(A.split("\\.")[0]), Long.parseLong(B));
//        }


        String[] arrA = A.split("\\.");
        String[] arrB = B.split("\\.");

        int n = arrA.length;
        int m = arrB.length;

        List<BigInteger> lbiA = Arrays.stream(arrA).map(BigInteger::new).collect(Collectors.toList());
        List<BigInteger> lbiB = Arrays.stream(arrB).map(BigInteger::new).toList();

        int i = 0, j = 0;
        while (i<n){

            if(j==m){
                break;
            }

            int k = lbiA.get(i).compareTo(lbiB.get(j));
            if(k < 0){
                return -1;
            } else if (k > 0){
                return 1;
            } else {
                i++;
                j++;
            }
        }
        if(i != n && j == m && !lbiA.get(i).equals(new BigInteger("0"))){
            return 1;
        }
        if(j != m && i == n && !lbiB.get(j).equals(new BigInteger("0"))){
            return -1;
        }
        return 0;
    }

    public static int minPalindrome1(String A) {

        int i = 0, j = A.length()-1;

        while (i < j){
            while (A.charAt(i) != A.charAt(j)){
                i++;
            }
            boolean isPalin = isPalindrome(A.substring(i, j+1));
            if(isPalin){
                return i;
            }
            i++;
        }
        return i;
    }

    public static int minPalindrome(String A) {
        int i = 0, j = A.length()-1;
        int count = 0;
        while (i < j){
            if(A.charAt(i) != A.charAt(j)){
                count++;
                i = count;
                j = A.length()-1;
            } else {
                i++;
                j--;
            }
        }

        return count;
    }

    public static int convertToPalindrome(String A) {

        // abeebea
        int i = 0;
        int j = A.length()-1;
        while (i<j){
            if(!(A.charAt(i) == A.charAt(j))){
                break;
            }
            i++;
            j--;
        }
        if(i == j){
            return 1;
        }
        if(i-1 == j){
            return 0;
        }

        if(i != j && i < j) {
            boolean right = isPalindrome(A.substring(i, j));
            if(right){
                return 1;
            }
            boolean left = isPalindrome(A.substring(i+1, j+1));
            if(left){
                return 1;
            }
        }

        return 0;
    }

    public static boolean isPalindrome(String A){
        int i = 0;
        int j = A.length()-1;

        while (i<j){
            if(!(A.charAt(i) == A.charAt(j))){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static String reverseStringByWords(String A) {
        // the sky is blue
        // eulb si yks eht
        // blue is sky the
        String[] strArr = A.split("");
        int n = A.length();
        int i = 0, j = n-1;
        while(i <= j){
            String temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
            i++;
            j--;
        }

        j = 0;

        while(j < n){
            i = j;
           while (j < n && !Objects.equals(strArr[j], " ")){
               j++;
           }

           int k = j-1;
           while (i <= k){
               String temp = strArr[i];
               strArr[i] = strArr[k];
               strArr[k] = temp;
               i++;
               k--;
           }

           while (j < n && Objects.equals(strArr[j], " ")){
               j++;
           }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0]);
        for(int k = 1; k<n; k++){
            if(Objects.equals(strArr[k - 1], " ") && Objects.equals(strArr[k], " ")){
                continue;
            }
            sb.append(strArr[k]);
        }
        String ans = sb.toString();
        return ans.trim();
    }

    public static Long countSalutes(String A) {

        int[] arr = new int[A.length()];

        int count = 0;
        for(int i = A.length()-1; i>=0; i--){
            if(A.charAt(i) == '<'){
                count++;
            }
            arr[i] = count;
        }

        long solute = 0L;
        for(int i = 0; i<A.length(); i++){
            if(A.charAt(i) == '>'){
                solute += arr[i];
            }
        }
        return solute;
    }

    public static String printAlternate(String A, String B){
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        while(i<A.length() && j <B.length()){
            sb.append(A.charAt(i));
            sb.append(B.charAt(j));
            i++;
            j++;
        }

        while (i<A.length()){
            sb.append(A.charAt(i));
            i++;
        }

        while (j < B.length()){
            sb.append(B.charAt(j));
            j++;
        }

        return sb.toString();
    }

    public static int minParentheses(String A) {
        Stack<Character> open = new Stack<>();
        Stack<Character> close = new Stack<>();

        for(Character c: A.toCharArray()){
            if(c == '('){
                if(!close.isEmpty() && close.peek() == ')'){
                    close.pop();
                } else {
                    open.push(c);
                }
            } else {
                if(!open.isEmpty() && open.peek() == '('){
                    open.pop();
                } else {
                    close.push(c);
                }
            }
        }

        return open.size()+close.size();
    }

    public static int strStr(final String A, final String B) {

        int n = A.length();
        int idxA = 0;
        int m = B.length();
        int idxB = 0;
        while(idxA < n){
            if(idxB < m && A.charAt(idxA) == B.charAt(idxB)){
                idxB++;
            } else {
                idxB = 0;
            }
            if(idxB == m){
                idxA++;
                break;
            }
            idxA++;
        }

        return idxB == 0? -1 : idxA-idxB;
    }

    public static int anagramSentences(){



        return 0;
    }

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        HashSet<String> setWords = new HashSet<>();

        for(String s: sentences){
            String[] sArr = s.split(" ");
            setWords.addAll(Arrays.asList(sArr));
        }

        HashMap<Integer, List<String>> map = new HashMap<>();

        for(String s: wordSet){
            if(map.containsKey(s.length())){
                map.get(s.length()).add(s);
            } else {
                map.put(s.length(), new ArrayList<>());
            }
        }

        HashMap<String, Integer> map2 = new HashMap<>();
        for(String s: setWords){
            List<String> listWords = map.get(s.length());
            for(String word : listWords){
                if(!Objects.equals(word, s)){
                    if(isAnagram(s, word)){
                        map2.put(s, map2.getOrDefault(s, 0)+1);
                    }
                }
            }
        }

        List<Long> ans = new ArrayList<>();
        for(String s: sentences){
            String[] sArr = s.split(" ");
            long countA = 1L;
            for(String k: sArr){
                if(map2.containsKey(k)){
                    long val = map2.get(k);
                    countA = countA * 2;
                }
            }
            ans.add(countA);
        }

        return ans;
    }

    public static boolean isAnagram(String s1, String s2){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(Character c: s1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(Character c: s2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry: map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                if(!Objects.equals(map2.get(entry.getKey()), entry.getValue())){
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static int amazingSubstring(String A) {
        int ans = 0;

        int n = A.length();
        A = A.toLowerCase();
        // 97, 101, 105, 111, 117

        for(int i =0; i<n; i++){
            if(A.charAt(i) == 97 || A.charAt(i) == 101 || A.charAt(i) == 105 || A.charAt(i) == 111 || A.charAt(i) == 117){
                ans = (ans + (n-i)%10003)%10003;
            }
        }

        return ans%10003;
    }

    public static String countAndSay(int A) {

        /*
        1,
        11,
        21,
        1211,
        111221
        312211 //312211
        13112221 // 13112221
        1113213211 // 1113213211
        */
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");

        int n = 1;
        while(n < A){
            String s = countAndSayHelper(map.get(n));
            n++;
            map.put(n, s);
        }
        return map.get(A);
    }

    public static String countAndSayHelper(String A){
        int len = A.length();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (idx<len){
            char i = A.charAt(idx);
            int count = 0;
            while (idx<len && A.charAt(idx) == i){
                count++;
                idx++;
            }
            sb.append(count+""+i);
        }

        return sb.toString();
    }


    public static String longestCommonPrefix(ArrayList<String> A) {
        int len = 0;
        boolean prefix = false;

        int idx = 0;
        while (true) {
            char c;
            if(A.get(0).length() == idx){
                break;
            }

            c = A.get(0).charAt(idx);
            for (int i = 1; i < A.size(); i++) {
                if (A.get(i).length() == idx) {
                    prefix = false;
                    break;
                } else {
                    if (A.get(i).charAt(idx) != c) {
                        prefix = false;
                        break;
                    } else {
                        prefix = true;
                    }
                }
            }

            if(prefix){
                len++;
                idx++;
            } else {
                break;
            }
        }

        return A.get(0).substring(0, len);
    }

    public static int permuteStrings(String A, String B) {
        if(A.length() != B.length()){
            return 0;
        }
        HashMap<Character, Integer> setA = new HashMap<>();
        HashMap<Character, Integer> setB = new HashMap<>();

        for(char c: A.toCharArray()){
            setA.put(c, setA.getOrDefault(c, 0)+1);
        }

        for(char c: B.toCharArray()){
            setB.put(c, setB.getOrDefault(c, 0)+1);
        }

        if(setA.size() != setB.size()){
            return 0;
        }

        for(Map.Entry<Character, Integer> entry: setA.entrySet()){
            if(!Objects.equals(setB.get(entry.getKey()), entry.getValue())){
                return 0;
            }
        }


        return 1;
    }

    public static String bullsCows(String A, String B) {
        HashMap<String, Integer> secretMap = new HashMap<>();
        HashMap<String, Integer> guessMap = new HashMap<>();
        int bulls = 0, cows = 0;

        for(String s: A.split("")){
            secretMap.put(s, secretMap.getOrDefault(s, 0)+1);
        }

        for(String s: B.split("")){
            guessMap.put(s, guessMap.getOrDefault(s, 0)+1);
        }

        String[] g = B.split("");
        String[] s = A.split("");
        for(int i = 0; i< s.length; i++){
            String num1 = s[i];
            String num2 = g[i];
            if(num1.equals(num2)){
                bulls++;
            }
        }

        for (Map.Entry<String, Integer> entry: secretMap.entrySet()){
            if(guessMap.containsKey(entry.getKey())){
                int n1 = entry.getValue();
                int n2 = guessMap.get(entry.getKey());
                cows += Math.min(n1, n2);
            }
        }
        cows -= bulls;

        return bulls+"A"+cows+"B";
    }

    public static String StringFreq(String A) {
        // abbhuabcfghh
        // a2b3h3u1c1f1g1
        int[] arr = new int[26];
        for(char c: A.toCharArray()){
            arr[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        HashSet<Character> cSet = new HashSet<>();
        for(char c: A.toCharArray()){
            if(cSet.contains(c)){
                continue;
            }
            cSet.add(c);
            sb.append(c);
            sb.append(arr[c-'a']);
        }

        return sb.toString();
    }

    public static int lengthOfLastWord(final String A) {
        String[] strArr = A.split(" ");
        int n = strArr.length;

        return strArr[n-1].length();
    }

    public static ArrayList<String> deserializeString(String A) {
        String[] str = A.split("~");
        ArrayList<String> ans = new ArrayList();
        for(String s: str){
            int n = s.length();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while(i < n){
                if(s.charAt(i) >= 48 && s.charAt(i) <= 57 ){
                    break;
                } else {
                    sb.append(s.charAt(i));
                    i++;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public static int numToWords(String A, String B) {
        int n = Integer.parseInt(A);
        String res = "";
        res+=numToStr((n/10000000),"crore-");
        res+=numToStr((n/100000)%100,"lakh-");
        res+=numToStr((n/1000)%100,"thousand-");
        res+=numToStr((n/100)%10,"hundred-");
        if(n>100 && n%100!=0){
            res+="and-";
        }
        res+=numToStr((n%100),"");
        String match = res.substring(0,res.length()-1);
        if(B.equals(match)){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static  String numToStr(int n, String str){
        String[] units = {"","one-","two-","three-","four-","five-","six-","seven-","eight-","nine-","ten-","eleven-","twelve-","thirteen-","fourteen-","fifteen-","sixteen-","seventeen-","eighteen-","nineteen-"};
        String[] tens = {"","","twenty-","thirty-","forty-","fifty-","sixty-","seventy-","eighty-","ninety-"};
        String res ="";
        if(n>19){
            res+= tens[n/10] + units[n%10];
        }
        else{
            res+=units[n];
        }
        if(n!=0){
            res+=str;
        }
        return res;
    }

    public static int vowelConsonantSubs(String A) {
        int n = A.length();
        int[] vow = new int[n];
        int[] con = new int[n];

        ArrayList<Integer> vowList = new ArrayList<>(Arrays.asList(97, 101, 105, 111, 117));
        char c = A.charAt(n-1);
        if(vowList.stream().anyMatch(value -> value == c)){
            vow[n-1]=1;
            con[n-1]=0;
        } else {
            con[n-1]=1;
            vow[n-1]=0;
        }

        for(int i = n-2; i>=0; i--){
            char k = A.charAt(i);
            if(vowList.stream().anyMatch(value -> value == k)){
                vow[i] = vow[i+1] + 1;
                con[i] = con[i+1];
            } else {
                con[i] = con[i+1] + 1;
                vow[i] = vow[i+1];
            }
        }

        int count = 0;
        int mod = 1000000007;
        for (int i = 0; i<n-1; i++){
            char k = A.charAt(i);
            if(vowList.stream().anyMatch(value -> value == k)){
                count = (count + con[i+1]) % mod;
            } else {
                count = (count + vow[i+1]) % mod;
            }
        }
        return count;



        /*
          ansdsaiacodfu
          1000011101001
          7765433332210

          0111100010110
          6555554322111

          7    333 2  0 => 18
          ansdsaiacodfu
           5555   2 11  => 24 => 42

        */

//        return 0;
    }

    public static int goodSubarrays(ArrayList<Integer> A, int B) {
        return atMostK(A, B) - atMostK(A, B - 1);
    }
    static int atMostK(ArrayList<Integer> A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < A.size(); ++j) {
            if (map.getOrDefault(A.get(j), 0) == 0)
                K--;
            map.put(A.get(j), map.getOrDefault(A.get(j), 0) + 1);

            while (K < 0) {
                map.put(A.get(i), map.get(A.get(i)) - 1);
                if (map.get(A.get(i)) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < A.size() && p2 < B.size()){
            while (p1 < A.size() && p2 < B.size() && (A.get(p1) < B.get(p2))){
                p1++;
            }
            while (p1 < A.size() && p2 < B.size() && (B.get(p2) < A.get(p1))){
                p2++;
            }
            if( p1 < A.size() && p2 < B.size() && ((int) A.get(p1) == (int) B.get(p2))){
                ans.add(A.get(p1));
                p1++;
                p2++;
            }

        }

        return ans;
    }

    public static int countRightAngleTriangle(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        HashMap<Integer, Integer> xCord = new HashMap<>();
        HashMap<Integer, Integer> yCord = new HashMap<>();

        for(int i = 0; i<n; i++){
            xCord.put(A.get(i), xCord.getOrDefault(A.get(i), 0)+1);
            yCord.put(B.get(i), yCord.getOrDefault(B.get(i), 0)+1);
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            int x = A.get(i);
            int y = B.get(i);
            int xCount = xCord.get(x);
            int yCount = yCord.get(y);
            ans += ((xCount-1)*(yCount-1));
        }

        return ans;
    }

    public static int countRectangle(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        HashSet<Pair> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(new Pair(A.get(i), B.get(i)));
        }
        int count = 0;
        for(int i = 0; i < n-1; i++){
            int xi = A.get(i);
            int yi = B.get(i);
            for (int j = i+1; j < n; j++){
                int xj = A.get(j);
                int yj = B.get(j);

                if(xi != xj && yi != yj){
                    Pair p1 = new Pair(xi, yj);
                    Pair p2 = new Pair(xj, yi);
                    if(set.contains(p1) && set.contains(p2)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        return count/2;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x*31+y;
        }

        @Override
        public String toString() {
            return this.x+"_"+this.y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(obj == null || getClass() != obj.getClass()){
                return false;
            }
            Pair that = (Pair) obj;
            return (this.x == that.x && this.y == that.y);
        }
    }

    public static int replicatingSubstring(int A, String B) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(Character b: B.toCharArray()){
            map.put(b, map.getOrDefault(b, 0)+1);
        }

        for(Integer i: map.values()){
            if(i%A != 0){
                return -1;
            }
        }

        return 1;
    }

    public static int pointsInLine(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int maxPointsInLine = Integer.MIN_VALUE;
        int count = 1;
        HashMap<Pair, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j<n; j++){
                if(i != j){
                   Pair slope = getSlope(A.get(i), B.get(i), A.get(j), B.get(j));
                   map.put(slope, map.getOrDefault(slope, 0)+1);
                } else {
                    count++;
                }
            }
            int maxSlope = Integer.MIN_VALUE;
            for(Integer k: map.values()){
                maxSlope = Math.max(maxSlope, k+count);
            }
            maxPointsInLine = Math.max(maxPointsInLine, maxSlope);
            map = new HashMap<>();
        }
        System.out.println(maxPointsInLine);
        return maxPointsInLine;
    }

    public static Pair getSlope(int x1, int y1, int x2, int y2){
        // m = y2-y1/ x2-x1
        int numerator = y2-y1;
        int denominator = x2-x1;
        if(numerator == 0 || denominator == 0){
            return new Pair(numerator, denominator);
        }
        int gcdN = gcd(numerator, denominator);

        return new Pair(numerator/gcdN, denominator/gcdN);
    }

    public static int gcd(int a, int b){

        if(b == 0){
            return a;
        }
        return gcd(b, a%b);

    }

    public static int nTriangle(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        int count = 0;

        for (int i = n - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (A.get(l) + A.get(r) > A.get(i)) {
                    count += r - l;
                    r--;
                }
                else {
                    l++;
                }
            }
        }

        return count;
    }

}

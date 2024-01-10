package ProblemSolving;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class ProblemsBefore10Jan2024 {

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

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
//        System.out.println(longestCommonPrefix(new String[] {"abcd","abcd","efgh"}));
//        System.out.println("Hello World!, printed by" + Thread.currentThread().getName());
//        Runnable runnable = () -> {
//            System.out.println("Hello World!, printed by" + Thread.currentThread().getName());
//        };
//        Thread t1 = new Thread(runnable);
//        t1.start();

//        oddNums(Arrays.asList(1,2,3,4,5,6,7,8,9,9));

//        ExecutorService es  = Executors.newFixedThreadPool(4);
//
//        for (int i = 1; i<=100; i++){
//            int finalI = i;
//            Runnable r = () -> System.out.println(finalI + " from Thread: " + Thread.currentThread().getName());
//            es.execute(r);
//        }
//        es.close();

//        int k = magicNum1(83557);
//        System.out.println(k);
//        if(k == 1) System.out.println("Magic Num");
//        else System.out.println("Not magic num");

//        TOH(3,1,2,3,ans);
//        System.out.println(ans);

//        isValid(")]");

//        System.out.println(reverseStr("lkjhgf"));
//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
//        A.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
//        A.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
//
//        ArrayList<ArrayList<Integer>> B = performOps(A);
//        for (ArrayList<Integer> integers : B) {
//            for (Integer integer : integers) {
//                System.out.print(integer + " ");
//            }
//        }

//        rotateArray(new ArrayList<>(Arrays.asList(14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35)), 56);

//        ArrayList<Integer> B = performOps1(new ArrayList<>(Arrays.asList(5,10,2,1)));
//        for (Integer integer : B) {
//            System.out.print(integer + " ");
//        }

//        System.out.println(prettyPrint(5));
//        System.out.println(grayCode(4));

//        String ans = kthSym(5);
//        System.out.println(ans);
//        char i = ans.charAt(5);
//        System.out.println(i);
//
//        ICanFly ic = new Sparrow();
//        Bird b = new Sparrow();
//        Bird k = new Kiwi();

//        isPrime();
//        isPerfectNum();
//        System.out.println(isPerfectSquare(144));
//        armstrongNum(500);
//        System.out.println(climbingStairs(new ArrayList<>(Arrays.asList(5,68,68,94,39,52,84,4,6,53,68,1,39,7,42,69,59,
//                94,85,53,10,66,42,71,92,77,27,5,74,33,64,76,100,37,25,99,73,76,66,8,64,89,28,44,77,48,24,28,36,17,49,
//                90,91,7))));

//        List<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
//        A.add(new ArrayList<>(Arrays.asList( 5, 6, 7, 8)));
//        A.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
//        A.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
//        A.add(new ArrayList<>(Arrays.asList(17, 18, 19, 20)));
//        A.add(new ArrayList<>(Arrays.asList(21, 22, 23, 24)));
//        System.out.println(spiralOrder(A));

//        System.out.println(solveFactorialBig(10));

//        System.out.println(strMul("45629", 2));
//        Pattern.quote("");

//        int[] A = {336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421};
//        System.out.println(maxset(A));

//        List<Integer> items = Arrays.asList(1,2,3);
//        List<String> itemsStr = items.stream().map(Object::toString).collect(Collectors.toList());
//        String commaSeparated = String.join((CharSequence) ", ", itemsStr);
//        System.out.println(commaSeparated);

        int arr[] = new int[] {};
        int idx = rotationIdx(arr);
        int ans = binSearchH(arr, idx, 9);
        System.out.println(ans);

    }


    static String strMul(String s, int n){
        if(s.isEmpty()){
            return String.valueOf(n);
        }
        String ans = "";
        int carry = 0;
        for(int i = s.length()-1; i>=0; i--){

            int digit = s.charAt(i)-'0';
            int multiple = (digit*n)+carry;
            int unitPlace = multiple%10;
            carry = multiple/10;
            ans = unitPlace+ans;
        }
        if(carry!=0)
            ans = carry+ans;
        return ans;

    }

    public static String solveFactorialBig(int A) {

        String  ans="";
        while(A>1){
            ans  = stringMultiply(ans,A);
            A--;
        }

        return ans;
    }

    public static String stringMultiply(String s,int n){
        if(s.isEmpty()){  // empty treated as 1
            return String.valueOf(n);
        }

        int carry=0;
        String  ans="";
        for(int i= s.length()-1; i>=0 ; i--){

            int digit = s.charAt(i) - '0';
            int multiply = (digit * n) + carry;
            int unitPlace = multiply%10;

            carry = multiply/10;
            ans  = unitPlace + ans;
        }

        if(carry!=0){
            ans = carry+ans;
        }

        //System.out.println(ans+" S:"+s+" N:"+n);
        return ans;

    }

    static String factBig(int A){
        BigInteger bigI = BigInteger.ONE;
        for(int i=2; i<=A; i++){
            bigI = bigI.multiply(BigInteger.valueOf(i));
        }
        return String.valueOf(bigI);
    }

    static long fact(int A){
        if(A==1) return 1;
        return fact(A-1)* (long) A;
    }

    public static int[] maxset(int[] A) {
        long currMaxSum = 0;
        long prevMaxSum = 0;
        long currSum = 0;
        int prevStartIdx = 0;
        int prevEndIdx = 0;
        int currStartIdx = 0;
        int currEndIdx = 0;

        for(int i = 0; i<A.length; i++){
            if(A[i] < 0 && currSum >= 0){
                currStartIdx = i+1;
                currEndIdx = currStartIdx;
                currSum = 0;
                continue;
            }
            currSum += A[i];
            if(currSum < 0){
                currStartIdx = i+1;
                currEndIdx = currStartIdx;
                currSum = 0;
                continue;
            }
            currEndIdx = i;
            currMaxSum = currSum;
            if(currMaxSum>prevMaxSum){
                prevMaxSum = currMaxSum;
                prevStartIdx = currStartIdx;
                prevEndIdx = currEndIdx;
            } else if (currMaxSum == prevMaxSum){
                int currLen = currEndIdx - currStartIdx + 1;
                int prevLen = prevEndIdx - prevStartIdx + 1;
                if(currLen>prevLen){
                    prevStartIdx = currStartIdx;
                    prevEndIdx = currEndIdx;
                }
            }
        }

        return Arrays.copyOfRange(A,prevStartIdx,prevEndIdx+1);
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int r = A.size();
        int c = A.get(0).size();
        int k = c-1;
        int l = r-1;
        int size = r*c;
        int count = 0;
        int i = 0, j = 0;
        while ((k>0 || l>0) && count<size){
            for(int n=0; n<k; n++){
                ans.add(A.get(i).get(j));
                count++;
                j++;
            }
            for(int n=0; n<l; n++){
                ans.add(A.get(i).get(j));
                count++;
                i++;
            }
            for(int n=0; n<k; n++){
                ans.add(A.get(i).get(j));
                count++;
                j--;
            }
            for(int n=0; n<l; n++){
                ans.add(A.get(i).get(j));
                count++;
                i--;
            }
            k=  k-2;
            l = l-2;
            i++; j++;
        }

        if(A.size()%2 != 0)
            ans.add(A.get(i).get(j));

        return ans;
        /*
        1 2
        3 4
        5 6
         */
    }

    public static int climbingStairs(ArrayList<Integer> A) {
        /*
            1,1,2,3,1,2,3,4,6,3,2 => 14
            4,2,1,3,4,2,3,4,6,3,2 => 19
            5,68,68,94,39,52,84,4,6,53,68,1,39,7,42,69,59,
                94,85,53,10,66,42,71,92,77,27,5,74,33,64,76,100,37,25,99,73,76,66,8,64,89,28,44,77,48,24,28,36,17,49,
                90,91,7
        */
        int n = A.size();
        int cost1 = 0;
        int i = n-1;
        cost1+=A.get(i);
        while(i>2){
            int j = i-1;
            int k = i-2;
            if(A.get(j) < A.get(k)){
                i = j;
            } else {
                i = k;
            }
            cost1+= A.get(i);
        }
        if(i!=0)
            cost1+=A.get(0);

        System.out.println(cost1);

        int cost2 = 0;
        i = 0;
        cost2+=A.get(i);
        while(i<n-2){
            int j = i+1;
            int k = i+2;
            if(A.get(j) < A.get(k)){
                i = j;
            } else {
                i = k;
            }
            cost2+= A.get(i);
        }
        if(i != n-1)
            cost2+=A.get(n-1);
        System.out.println(cost2);

        return Math.min(cost1, cost2);
    }

    public static int climbingStairs1(ArrayList<Integer> A) {
        /*
            1,1,2,3,1,2,3,4,6,3,2 // 1 1 2 1 2 3 4 3 2
            4,2,1,3,4,2,3,4,6,3,2 // 4 2 1 3 4 2 3 4 6 3 2
        */
//        n-1, n-2, n-3
        int n = A.size();
        int cost = 0;
        int i = 0;
        cost+=A.get(i);
        while(i<n-2){
            int j = i+1;
            int k = i+2;
            if(A.get(j) < A.get(k)){
                i = j;
            } else {
                i = k;
            }
            cost+= A.get(i);
        }
        if(i != n-1)
            cost+=A.get(n-1);

        return cost;
    }
    public static String kthSym(int A){
        if(A == 1)
            return "01";
        String previous = kthSym(A-1);
        int halfLen = previous.length() / 2;
        return previous+previous.substring(halfLen)+previous.substring(0,halfLen);
    }

     public static ArrayList < Integer > grayCode1(int A) {
        int n = 1 << A;
        ArrayList < Integer > result = new ArrayList < > ();
        // G[n] = n ^ (n >> 1)
        for (int i = 0; i < n; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    static ArrayList<Integer> grayCode(int A){
        if(A == 1) return new ArrayList<>(Arrays.asList(0,1));
        int n = 1 << A-1;
        ArrayList<Integer> ansList = new ArrayList<>(grayCode(A - 1));
        int t = ansList.size();
        for(int i = t-1; i>=0; i--){
            ansList.add(ansList.get(i)+n);
        }
        return ansList;
    }

//    Print concentric rectangular pattern in a 2d matrix.
    static public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int k = A+A-1-1;
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i = 0; i<=k; i++){
            mat.add(i, new ArrayList<>());
        }
        for(int i = 0; i<mat.size(); i++){
            for (int j = 0; j < mat.size(); j++){
                mat.get(i).add(j, 0);
            }
        }

        int i = 0, j = 0;
        while (k>0){
            for(int n=0; n<k; n++){
                mat.get(i).set(j, A);
                j++;
            }
            for(int n=0; n<k; n++){
                mat.get(i).set(j, A);
                i++;
            }
            for(int n=0; n<k; n++){
                mat.get(i).set(j, A);
                j--;
            }
            for(int n=0; n<k; n++){
                mat.get(i).set(j, A);
                i--;
            }
            k=k-2;
            A--;
            i++; j++;
        }

        mat.get(i).set(j, A);

        return mat;
    }

    static ArrayList<Integer> performOps1(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int n = A.size();
        B = B%n;
        for (int i = 0; i < n; i++) {
            if(i+B < A.size())
                ret.add(A.get(i + B));
            else
                ret.add(A.get(i+B-n));
        }
        return ret;
    }

    static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }


    public static void TOH(int disk, int s, int t, int d, ArrayList<ArrayList<Integer>> ans){
        if(disk == 0) return;
        TOH(disk-1, s, d, t, ans);
        // new ArrayList<>(new ArrayList<>(Arrays.asList(new Integer[] { n, source, destination }))));
        ans.add(new ArrayList<>(Arrays.asList(disk, s, d)));
        TOH(disk-1, t, s, d, ans);
    }

    public static String reverseStr(String s){

        if(s.length() <= 1) return s;
        int n = s.length();
        String ss = s.substring(1,n-1);
        String t = reverseStr(ss);

        return s.charAt(n-1)+t+s.charAt(0);
    }

    public static int isValid(String A) {
        HashSet<Character> opening = new HashSet<>(new ArrayList<>(Arrays.asList('(', '[', '{')));
        Stack<Character> stk = new Stack<>();

        for(Character c: A.toCharArray()){
            if(opening.contains(c)){
                stk.push(c);
            } else {
                if(!stk.isEmpty()){
                    if((c == ')' && stk.peek() == '(') || (c == ']' && stk.peek() == '[') || (c == '}' && stk.peek() == '{'))
                        stk.pop();
                    else
                        return 0;
                } else {
                    return 0;
                }
            }
        }

        if(stk.isEmpty())
            return 1;
        else
            return 0;
    }

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

    static void oddNums(List<Integer> list){
        List<Integer> oddList = list.stream().filter(n -> n%2 != 0).toList();
        System.out.println(oddList);
    }

    static int magicNum1(int A){
        if(A < 10) return A;
        return magicNum1(magicNum1(A/10) + A%10);

    }

    /*
    83557 -> 28
    8355  + 7 -> 10 -> 1
    835 + 5 -> 12 -> 3
    83 + 5 -> 7
    8 + 3 -> 11 -> 2 [fun(num/10) + num%10]
    8 (<10) return num

     */

    interface ICanFly {
        void fly();
    }

     abstract static class Bird{
        abstract void eat();
        abstract void poop();
    }

    static class Kiwi extends Bird{

        @Override
        void eat() {

        }

        @Override
        void poop() {

        }
    }

    static class Sparrow extends Bird implements ICanFly{

        @Override
        public void fly() {

        }

        @Override
        void eat() {

        }

        @Override
        void poop() {

        }
    }

    public static void isPrime() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        boolean prime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        System.out.println(prime ? "YES" : "NO");
    }

    public static void isPerfectNum() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; i++) {
            int num = scn.nextInt();
            isPerfectNumHelper(num);
        }
        scn.close();
    }

    public static void isPerfectNumHelper(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        int sum = divisors.stream().reduce(0, Integer::sum);
        System.out.println(sum == n ? "YES" : "NO");
    }

    public static int isPerfectSquare(int n) {
        int ans = -1;
        for (int i = 2; i * i <= n; i++) {
            if (i * i == n) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void armstrongNum(int n){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for(int i = 2; i<=n; i++){
            if(i == 153){
                System.out.println("Pause");
            }
            int num = i;
            System.out.println(i);
            ArrayList<Integer> digits = new ArrayList<>();
            while (num!=0){
                digits.add(num%10);
                num = num/10;
            }
            Double sum = digits.stream().map(t -> Math.pow(t, 3)).collect(Collectors.toList()).stream().reduce(0.0, Double::sum);
            if(sum.intValue() == i)
                list.add(i);
        }
        list.stream().forEach(System.out::println);
    }
    static int longestSub(int[] arr){
        int n = arr.length;
        int maxCount = Integer.MIN_VALUE;
        int lastOccIndex = -1;
        boolean foundOne = false;
        int localCount = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == 1 && !foundOne){
                foundOne = true;
                localCount++;
                if(localCount > maxCount){
                    maxCount = localCount;
                    lastOccIndex = i;
                }
                continue;
            }
            if(arr[i] == 0){
                foundOne = false;
                localCount = 0;
                continue;
            }
            if(foundOne && arr[i]==1){
                localCount++;
                if(localCount > maxCount){
                    maxCount = localCount;
                    lastOccIndex = i;
                }
            }
        }

        int countZero = 0;
        for(int i = 0; i<lastOccIndex;i++){
            if (arr[i] == 0){
                countZero++;
            }
        }

        if(maxCount > countZero){
            return countZero*2;
        } else {
            return maxCount*2;
        }

    }

    static int rotationIdx(int[] arr){
        //  9 10 11 12 13 14 1 2 3 4
        int n = arr.length;

        int s = 0;
        int e = arr.length - 1;
        while (s < e){
            int mid = (s+e)/2;
            if(arr[mid] > arr[n-1]){
                s = mid+1;
            } else {
                e = mid - 1;
            }
        }

        return e;
    }

    static int binarySearch(int arr[], int s, int e, int k){
        while (s <= e){
            int mid = (s+e)/2;
            if(arr[mid] == k){
                return mid;
            } else if(k < arr[mid]) {
                e = mid - 1;
            } else {
                s = mid+1;
            }
        }
        return -1;
    }
    static int binSearchH(int arr[], int idx, int k){
        int n = arr.length;
        int ans ;
        if(k < arr[0] && k < arr[idx]){
            ans = binarySearch(arr, idx+1, n-1, k);
        } else {
            ans = binarySearch(arr, 0, idx, k);
        }
        return ans;
    }

}

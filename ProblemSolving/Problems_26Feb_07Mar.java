package ProblemSolving;

import java.util.*;

public class Problems_26Feb_29Feb {
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
        numToWords("2167", "two-thousand-one-hundred-and-sixty-seven");
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

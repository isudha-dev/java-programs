package ProblemSolving;

import java.util.*;
import java.util.stream.Stream;

public class Problems08_020224 {
    public static void main(String[] args) {
//        System.out.println(PairsWithGivenDiff(new ArrayList<>(Arrays.asList(1,2)), 0));
//        System.out.println(solve(new int[]{1,1,1,2,2}, 0));
//        merge(new ArrayList<>(Arrays.asList(1,5,8,10,15)), new ArrayList<>(Arrays.asList(0,6,9, 12)));
//        System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3))));
//        System.out.println(sortArrayInGivenOrder(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4)), new ArrayList<>(Arrays.asList(5, 4, 2))));
//        System.out.println(colorful(236));
//        System.out.println(palindrome("vnpypznzpfxyivpppxfpp"));
//        twoSum(new ArrayList<>(Arrays.asList(1,1,1)), 2).forEach(System.out::println);
//        System.out.println(isPalindrome("rr"));
        System.out.println(max1sAfterModification(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1, 1, 1)), 2));
    }

    public static int max1sAfterModification(ArrayList<Integer> A, int B) {
        int n = A.size();
        int zeros = 0;
        int maxLen = Integer.MIN_VALUE;
        int p1 = 0;
        int p2 = 0;

        while (p1<n){
            if(A.get(p1) == 0){
                zeros++;
            }
            while (zeros > B){
                if(A.get(p2)==0){
                    zeros--;
                }
                p2++;
            }
            maxLen = Math.max(maxLen, p1-p2+1);
            p1++;
        }

        return maxLen;
    }

    public static int isPalindrome(String A) {
        A = A.toLowerCase();
        int p1 = 0;
        int p2 = A.length()-1;
        if(p1 == p2 || (p2 == p1+1 && A.charAt(p1) == A.charAt(p2))){
            return 1;
        }
        while (p1 <= p2){
            char c1 = A.charAt(p1);
            char c2 = A.charAt(p2);
            if((c1 >= 97 && c1 <= 122) || (c1 >= 48 && c1 <= 57)){
                if((c2 >= 97 && c2 <= 122) || (c2 >= 48 && c2 <= 57)){
                    if(c1 == c2){
                        p1++;
                        p2--;
                    } else {
                        return 0;
                    }
                } else {
                    p2--;
                }
            } else {
                p1++;
            }
        }

        return 1;
    }

    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i<A.size(); i++){
            if(map.containsKey(B-A.get(i))){
                al.add(map.get(B-A.get(i)));
                al.add(i+1);
                break;
            }
            else{
                if(map.containsKey(A.get(i))){
                    continue;
                }
                else{
                    map.put(A.get(i),i+1);
                }
            }
        }

        return al;
    }

    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        A.forEach(i -> map.put(i, map.getOrDefault(i, 0)+1));
        int ans = -1;
        for(int i: A){
            if(map.get(i) == 2){
                return i;
            }
        }
        return -1;
    }

    public static int palindrome(String A) {
        String[] aStr = A.split("");
        HashMap<String, Integer> map = new HashMap();
        Stream.of(aStr).forEach(i -> map.put(i, map.getOrDefault(i, 0)+1));
        long count = map.entrySet().stream().filter(i-> i.getValue()%2==0).count();
        if(count == map.size() || count == map.size()-1){
            return 1;
        }
        return 0;
    }

    public static ArrayList<Integer> sortArrayInGivenOrder(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeMap<Integer, Integer> frqMap = new TreeMap<>();
        A.stream().forEach(i -> frqMap.put(i, frqMap.getOrDefault(i, 0)+1));

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: B){
            if(A.contains(i)){
                int freq = frqMap.get(i);
                while (freq > 0){
                    ans.add(i);
                    freq--;
                }
                frqMap.remove(i);
            }
        }
        for(Map.Entry<Integer, Integer> entry: frqMap.entrySet()){
            int freq = frqMap.get(entry.getKey());
            while (freq > 0){
                ans.add(entry.getKey());
                freq--;
            }
        }

        return ans;
    }

    public static int colorful(int A) {
        // 3 32 324 3245
        // 2 24 245
        // 4 45
        // 5
        HashSet<Integer> set = new HashSet<>();
        String[] s = String.valueOf(A).split("");
        for(int i = 0; i<s.length; i++){
            int product = 1;
            for(int j = i; j<s.length; j++){
                product *= Integer.parseInt(s[j]);
                if(set.contains(product)){
                    return 0;
                } else {
                    set.add(product);
                }
            }
        }
        return 1;
    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int size = 0;
        for(int i = 0; i<n ; i++){
            if(size == B){
                ans.add(map.size());
                map.put(A.get(i-B), map.get(A.get(i-B))-1);
                if(map.get(A.get(i-B)) == 0){
                    map.remove(A.get(i-B));
                }
            } else if (size < B){
                size++;
            }
            map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
        }
        ans.add(map.size());
        return ans;
    }

    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int n = A.size();
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for(int i=1; i<=n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i - 1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int startIdx = 0, endIdx = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i<prefixSum.length; i++){
            if(map.containsKey(prefixSum[i])){
                int len = i-map.get(prefixSum[i]);
                if(len > maxLen){
                    startIdx = map.get(prefixSum[i])-1;
                    endIdx = i;
                    maxLen = len;
                }
            } else {
                map.put(prefixSum[i], i);
            }
        }
        if(startIdx == 0 && endIdx == 0){
            return new ArrayList<>();
        }
        return new ArrayList<>(A.subList(startIdx+1, endIdx));
    }

    public static int subarrayWithSumZero(ArrayList<Integer> A) {
        int n = A.size();
        HashSet<Integer> set = new HashSet<>();
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        set.add(prefixSum[0]);
        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1]+A.get(i-1);
            if(set.contains(prefixSum[i])){
                return 1;
            }
            set.add(prefixSum[i]);
        }

        return 0;
    }

    public static int shaggyAndDistance(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<A.size(); i++){
            if(map.containsKey(A.get(i))){
                ans = Math.min(ans, i-map.get(A.get(i)));
            }
            map.put(A.get(i), i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int longestConsecutive(final List<Integer> A) {
        HashSet<Integer> set = new HashSet<>();
        A.stream().forEach(i -> set.add(i));

        int ans = 0;
        for(int i: A){
            if(set.contains(i-1)){
                continue;
            } else {
                int len = 1;
                int num = i+1;
                while(set.contains(num)){
                    len++;
                    num++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        HashSet<Integer> set = new HashSet<>();
        a.removeIf(p -> !set.add(p));

        return a.size();
    }

    public static ArrayList<Integer> subarrayWithGivenSum(ArrayList<Integer> A, int B) {
        int n = A.size();
        if(n == 1 && A.get(0) == B){
            return A;
        }
        if(n == 1) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        int p1 = 0, p2 = 1;
        int sum = A.get(p1);
        while (p2<n){
            if(sum > B){
                sum -=A.get(p1);
                p1++;
            } else if (sum < B){
                sum += A.get(p2);
                p2++;
            } else {
                return new ArrayList<>(A.subList(p1,p2));
            }
        }
        if(p2 == A.size()){
            while (p1<p2){
                sum -= A.get(p1);
                p1++;
                if(sum == B){
                    return new ArrayList<>(A.subList(p1,p2));
                }
            }
        }
        return new ArrayList<>(Arrays.asList(-1));
    }

    public static int PairsWithGivenDiff(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        if(n == 1) return 0;
        int p1 = 0, p2 = 1;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        while (p2<n){
            if(B == 0 && p1 == p2){
                if(p2<n-1)
                    p2++;
                else
                    break;
            }
            int diff = A.get(p2)-A.get(p1);
            if(diff == B){
                if(!set.contains(A.get(p1))) {
                    count++;
                    set.add(A.get(p1));
                }
                p1++;
                p2++;
            } else if(diff > B){
                p1++;
            } else {
                p2++;
            }
        }

        return count;
    }

    public static int maxArea(ArrayList<Integer> A) {

        return 0;
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int p1 = 0, p2 = 0;
        int m = a.size();
        int n = b.size();

        while(p1<m && p2 < n){
            int i = a.get(p1);
            int j = b.get(p2);
            if(j<=i){
                a.add(p1, j);
                p1++;
                p2++;
            } else {
                p1++;
            }
            m = a.size();
        }

        while(p2 < n){
            a.add(b.get(p2));
            p2++;
        }

        a.forEach(System.out::println);
    }

    static class Pair {
        int x; int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || obj.getClass() != Pair.class){
                return false;
            }
            Pair that = (Pair) obj;
            return this.x == that.x && this.y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

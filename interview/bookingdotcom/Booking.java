package interview.bookingdotcom;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Booking {
    public static void main(String[] args) {
//        Hotel h1 = new Hotel(0,1,10);
//        Hotel h2 = new Hotel(1,2,20);
//        Hotel h3 = new Hotel(3,4,10);
//        Hotel h4 = new Hotel(7,8,5);
//        List<List<Integer>> ansList = topKScoreHotels(new ArrayList<>(Arrays.asList(h1,h2,h3,h4)), 2);
//        try {
//            findTopKMatches("beta", "interview/test.txt", 3).forEach(System.out::println);
//        } catch (IOException e) {
//            System.out.println(e.getLocalizedMessage());
//        }

//        Character[][] matrix = {{'E','W','W','W','E'}, {'W','B','B','B','W'},{'E','W','W','W','E'}};
//        System.out.println(captured(1,1, matrix, new boolean[matrix.length][matrix[0].length]));
//        System.out.println(isTrapped(matrix,1,1,matrix.length, matrix[0].length, new boolean[matrix.length][matrix[0].length]));
//        String[] input = new String[] { "Luis", "Hector", "Selena", "Emmanuel", "Amish", "Pie", "Rat"};
//        String[] input = new String[] {"Luis", "Sat", "Sam", "Mos", "Toss", "Sim", "Mik", "Kim", "Maya"};
//        arrangeWord(input);
//        String stars = new String(new char[5]).replace('\0', '*');
//        System.out.println(stars);

//        bagIntersection(new ArrayList<>(Arrays.asList(0,1,1,2,5,6)), new ArrayList<>(Arrays.asList(0,1,2,2,2,6)));

//        LocalDate dt = LocalDate.parse("2021-01-21");
//        System.out.println(dt);
//        wordCount("acacabcatghhellomvnsdbworld", new String[]{"aca","cat","hello","world"});

        minNumberOfPerfectSquare(20);

    }
    static class Hotel{
        int hotelId;
        String hotelName;
        int parentHotelId;
        int score;
        int rooms;
        public Hotel(String hotelName, int rooms){
            this.hotelName = hotelName;
            this.rooms = rooms;
        }

        public Hotel(int hotelId, int parentHotelId, int score) {
            this.hotelId = hotelId;
            this.parentHotelId = parentHotelId;
            this.score = score;
        }
    }
    static int minNumberOfPerfectSquare(int n){
        if (n <= 3) {
            System.out.println(n);
            return n;
        }

        int sqrt = (int)Math.sqrt(n);
        if (sqrt*sqrt == n) {
            // Number itself is perfect sqr
            System.out.println(1);
            return 1;
        }


        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j*j <= i; j++) {
                int temp = j*j;
                if (temp > n) {
                    break;
                }
                dp[i] = Math.min(dp[i], 1+dp[i-temp]);
            }
        }
        Arrays.stream(dp).forEach(System.out::println);
        return dp[n];
    }
    public static Map<String, Integer> wordCount(String stream, String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for(String w: words) counts.put(w, 0);
        List<Integer> wordLengths = counts.keySet().stream().map(String::length).distinct().sorted().collect(Collectors.toList());
        char[] chars = stream.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(!checkChars(chars, counts, wordLengths, i)) break;
        }
        return counts;
    }
    private static boolean checkChars(char[] stream, Map<String, Integer> counts, List<Integer> wordLengths, int begin) {
        for(int length: wordLengths) {
            int end = length + begin;
            if(end > stream.length) {
                return false;
            } else {
                char[] temp = Arrays.copyOfRange(stream, begin, end);
                String part = String.valueOf(temp);
                if(counts.containsKey(part)) {
                    counts.put(part, counts.get(part) + 1);
                }
            }
        }
        return true;
    }
    static class BookingData {
        String hotelName;
        LocalDate checkIn;
        LocalDate checkOut;


        public BookingData(String hotelName, String checkIn, String checkOut) {
            this.hotelName = hotelName;
            this.checkIn = LocalDate.parse(checkIn);
            this.checkOut = LocalDate.parse(checkOut);
        }
    }
    static List<List<Integer>> topKScoreHotels(List<Hotel> hotelList, int k){
        Map<Integer, Integer> hotelToParent = new HashMap<>();
        Map<Integer, Integer> hotelToRoot = new HashMap<>();

        for(Hotel h: hotelList){
            hotelToParent.put(h.hotelId, h.parentHotelId);
        }

        Map<Integer, Integer> scoreMap = new HashMap<>();
        for(Hotel h: hotelList){
            int rootHotelId = -1;
            if(hotelToRoot.containsKey(h.hotelId)){
                rootHotelId = hotelToRoot.get(h.hotelId);
            } else {
                rootHotelId = findRootNode(h.hotelId, hotelToParent);
                hotelToRoot.put(h.hotelId, rootHotelId);
            }
            scoreMap.put(rootHotelId, scoreMap.getOrDefault(rootHotelId, 0) + h.score);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(scoreMap.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        List<List<Integer>> ansList = new ArrayList<>();
        for(int i = 0; i<Math.min(2, list.size()); i++){
            ansList.add(new ArrayList<>(Arrays.asList(list.get(i).getKey(), list.get(i).getValue())));
        }

        return ansList;
    }
    static int findRootNode(int hotelId, Map<Integer, Integer> hotelToParent){
        if(hotelToParent.containsKey(hotelId) && hotelToParent.get(hotelId) != null){
            return findRootNode(hotelToParent.get(hotelId), hotelToParent);
        }
        return hotelId;
    }
    static Set<Integer> findCommonElements(List<List<Integer>> lists){

        return null;
    }
    static List<String> findTopKMatches(String w, String fileName, int k) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Deque<String> deque = new LinkedList<>();
        Pattern pattern = Pattern.compile(w);
        String line;


        while ((line = br.readLine()) != null){
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()){
                deque.add(line);
                break;
            } else {
                if(deque.size() == k){
                    deque.removeFirst();
                }
                deque.add(line);
            }
        }
        return deque.stream().toList();
    }
    static boolean captured(int r, int c, Character[][] matrix, boolean[][] visited){
        if(r <0 || r>matrix.length-1 || c <0 || c>matrix[0].length-1){
            return false;
        }
        Character val = matrix[r][c];
        visited[r][c] = true;

        int[] cols = {0,1,0,-1};
        int[] rows = {-1,0,1,0};

        for(int k = 0; k < 4; k++){
            int r1 = r + rows[k];
            int c1 = c + cols[k];
            if(!visited[r1][c1] && matrix[r1][c1] == val){
                if(captured(r1,c1, matrix, visited)){
                    return true;
                } else if( matrix[r1][c1] == 'E'){
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean isTrapped(Character[][] arr, int i, int j, int m, int n , boolean[][] visited) {
        int[] xAxis = {-1,0,1,0}; // top left down
        int[] yAxis = {0,1,0,-1};
        char sourceChar = arr[i][j];
        visited[i][j] = true;
        for (int k = 0; k < yAxis.length; k++) {
            int x = i + xAxis[k];
            int y = j + yAxis[k];
            if(isValidMove(arr, x, y, m, n) && !visited[x][y]) {
                if(arr[x][y] == sourceChar) {
                    boolean result = isTrapped(arr, x, y, m, n, visited);
                    if(result) {
                        return true;
                    }
                }else if(arr[x][y] == 'E') {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isValidMove(Character[][] arr, int x, int y, int m, int n) {
        return x >= 0 && y>=0 && x < m && y < n ;
    }
    static List<String> arrangeWord(String[] words){
        int n = words.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i< n-1; i++){
            for(int j = i+1; j<n; j++){
                connectWords(i,j,words,map);
            }
        }
        boolean[] visited = new boolean[n];
        List<String> results = new ArrayList<>();
        int totalNum = words.length;
        boolean found = false;

        for(int i = 0; i < n; i++){
            int currNum = 0;
            if(dfs(i, visited, results, currNum, totalNum, words, map))
                break;
        }
        results.stream().forEach(System.out::println);
        return results;
    }
    static void connectWords(int i, int j, String[] words, Map<Integer, List<Integer>> map){
        String w1 = words[i].toLowerCase();
        String w2 = words[j].toLowerCase();
        if(w1.charAt(w1.length()-1) == w2.charAt(0)) {
            if(!map.containsKey(i)){
                map.put(i, new ArrayList<>());
            }
            map.get(i).add(j);
        }

        if(w2.charAt(w2.length()-1) == w1.charAt(0)) {
            if(!map.containsKey(j)){
                map.put(j, new ArrayList<>());
            }
            map.get(j).add(i);
        }
    }
    static boolean dfs(int i, boolean[] visited, List<String> results, int currNum, int totalNum, String[] words, Map<Integer, List<Integer>> map){
        currNum++;
        visited[i] = true;
        results.add(words[i]);
        boolean found = false;

        if(currNum == totalNum){
            return true;
        }

        if(map.containsKey(i)){
            for(Integer k : map.get(i)){
                if(!visited[k]){
                    found = dfs(k,visited,results,currNum,totalNum,words,map);
                }
            }
        }

        if(found){
            return found;
        }

        currNum--;
        visited[i] = false;
        results.removeLast();

        return false;
    }
    static List<Integer> bagIntersection(List<Integer> i1, List<Integer> i2){
        Collections.sort(i1);
        Collections.sort(i2);
        List<Integer> ans = new ArrayList<>();

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int p1 = 0; int p2 = 0;
        while (p1<i1.size() && p2<i2.size()){
            if(i1.get(p1) == i2.get(p2)){
                ans.add(i1.get(p1));
                p1++;
                p2++;
            } else {
                if(i1.get(p1) < i2.get(p2)){
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        ans.stream().forEach(System.out::println);
        return ans;
    }
    static void confirmBookings(String hotelsCsv, String bookingsCsv) throws IOException {
        List<Hotel> hotelList = new ArrayList<>();
        List<BookingData> bookingDataList = new ArrayList<>();
        Map<BookingData, String> bookingConfirm = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(hotelsCsv));
        String line;
        while ((line = br.readLine()) != null){
            String[] strs = line.split(" ");
            hotelList.add(new Hotel(strs[0], Integer.parseInt(strs[1])));
        }

        br = new BufferedReader(new FileReader(bookingsCsv));
        while ((line = br.readLine()) != null){
            String[] strs = line.split(" ");
            bookingDataList.add(new BookingData(strs[0], strs[1], strs[2]));
        }



    }

}

package hld;

import java.util.*;
import java.util.stream.Collectors;

public class ConsistentHashing {

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B, ArrayList<Integer> C) {
        ArrayList<Integer> ans = new ArrayList<>();
        int totalAssigned = 0;
        int n = A.size();
        for(int i = 0; i < n; i++){
            if(A.get(i).equals("ADD")){
                ans.add(totalAssigned);
                totalAssigned++;
            } else if (A.get(i).equals("REMOVE")) {
                ans.add(totalAssigned);
                totalAssigned--;
            } else {
                ans.add(userHash(B.get(i), C.get(i)));
            }
        }

        return ans;
    }

    public static ArrayList<Integer> solve1(List<String> A, List<String> B, List<Integer> C) {
        ArrayList<Integer> ans = new ArrayList<>();
        /*
        A = [ADD, ASSIGN, ASSIGN, ADD, ASSIGN, ASSIGN, REMOVE, ASSIGN]
        B = [INDIA, IRYA, RGJK, RUSSIA, BGVH, SUKJ, INDIA, RBRF]
        C = [11, 31, 7, 3, 5, 13, 23, 17]
         */


        int[] arr = new int[360];
        for(int i = 0; i < 359; i++){
            arr[i] = -1;
        }

        HashSet<Integer> serverAssignedDeg = new HashSet<>();
        HashMap<Integer, Integer> serverMap = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        int n = A.size();
        for(int i = 0; i < n; i++){
            if(A.get(i).equals("ADD")){
                int a = userHash(B.get(i), C.get(i));
                map.put(B.get(i), a);
                serverAssignedDeg.add(a);
                serverMap.put(a, 0);
                arr[a] = 0;
                ans.add(serverMap.get(a));
            } else if (A.get(i).equals("REMOVE")) {
                ans.add(serverMap.get(map.get(B.get(i))));

            } else {
                int a = userHash(B.get(i), C.get(i));
                int b = assignServer(serverAssignedDeg, a);
                serverMap.put(b, serverMap.get(b) +1);
                ans.add(a);
            }

        }



        return ans;
    }

    public static int findNextServer(HashSet<Integer> serverAssignedDeg, HashMap<Integer, Integer> serverMap, int deg){



        return 0;
    }

    public static int assignServer(HashSet<Integer> serverAssignedDeg, int deg){
        if(serverAssignedDeg.size() == 1){
            return serverAssignedDeg.iterator().next();
        }
        int nearMax = Integer.MAX_VALUE;
        for(int i: serverAssignedDeg){
            if(i > deg && i < nearMax){
                nearMax = i;
            }
        }

        if(nearMax == Integer.MAX_VALUE){
            for(int i: serverAssignedDeg){
                if(i<deg && i > nearMax){
                    nearMax = i;
                }
            }
        }
        return nearMax;
    }

    public static void main(String[] args) {
//        System.out.println(userHash("INDIA", 11));
//        System.out.println(userHash("IRYA", 31));
//        System.out.println(userHash("RGJK", 7));
//        System.out.println(userHash("RUSSIA", 3));
//        System.out.println(userHash("BGVH", 5));
//        System.out.println(userHash("SUKJ", 13));
//        System.out.println(userHash("INDIA", 23));
//        System.out.println(userHash("RBRF", 17));

//        HashSet<Integer> serverAssignedDeg = new HashSet<>();
//        serverAssignedDeg.add(267);
//
//
//        System.out.println(assignServer(serverAssignedDeg, 23));
//        System.out.println(assignServer(serverAssignedDeg, 10));
//        serverAssignedDeg.add(297);
//        System.out.println(assignServer(serverAssignedDeg, 147));
//        System.out.println(assignServer(serverAssignedDeg, 1));
//        System.out.println(assignServer(serverAssignedDeg, 287));
//        serverAssignedDeg.remove(267);
//        System.out.println(assignServer(serverAssignedDeg, 172));
//
//        HashSet<Integer> hs = new HashSet<>();
//        hs.add(267);
//        hs.remove(267);

        ArrayList<String> A = new ArrayList<>(Arrays.asList("ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN"));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("INDIA","VLVL","OXXV","HHGN","RUSSIA","AWNF","SPHI","FXKT","CHINA","JXZU","BWPK","JYWN","GERMANY","ZKYK","HLQZ","BRMS","INDIA","FMVA","NPJO","GACA","RUSSIA","ZMWM","XVUA","IDUW","CHINA","EHWW","KROX"));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(431,563,223,761,197,409,31,223,769,619,991,613,139,797,547,821,-1,131,577,269,-1,499,599,29,-1,13,337));

        // 0,207,207,207,3,207,207,207,0,59,251,207,0,59,207,207,6,251,59,251,4,251,59,251,11,59,59

//        ArrayList<String> A = new ArrayList<>(Arrays.asList("ADD","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","REMOVE","ASSIGN"));
//        ArrayList<String> B = new ArrayList<>(Arrays.asList("INDIA","GSZJ","ORWX","RUSSIA","IENS","TTXU","INDIA","CHEX"));
//        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(211,181,919,383,571,127,-1,97));

//        ArrayList<String> A = new ArrayList<>(Arrays.asList("ADD", "ASSIGN", "ADD", "ASSIGN", "REMOVE", "ASSIGN"));
//        ArrayList<String> B = new ArrayList<>(Arrays.asList("INDIA", "NWFJ", "RUSSIA", "OYVL", "INDIA", "IGAX"));
//        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(7, 3, 5, 13, -1, 17));

        ArrayList<Integer> output = solveNew(A, B, C);

        output.forEach(System.out::println);


//        System.out.println(getUpperbound(new ArrayList<>(Arrays.asList(5, 25, 50, 100, 150, 200, 300)), 300));
    }

    public static int userHash(String username, int hashKey){
     int p = hashKey;
     int n = 360;
        int hashCode = 0;
        long p_pow = 1;
        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);
            hashCode = (int) ((hashCode + (character - 'A' + 1) * p_pow) % n);
            p_pow = (p_pow * p) % n;
        }
        return hashCode;
    }


    public static ArrayList<Integer> solveNew(ArrayList<String> A, ArrayList<String> B, ArrayList<Integer> C) {

        HashMap<String, Integer> requestMapping = new HashMap<>(); // reqStr, reqHashVal
        HashMap<String, Integer> serverMapping = new HashMap<>(); // serverStr, serverHashVal
        TreeMap<Integer, ArrayList<String>> sortedReqMapping = new TreeMap<>(); // serverHashVal, list of req assigned

        ArrayList<Integer> output = new ArrayList<>();

        for(int i = 0; i<A.size(); i++){
            switch (A.get(i)) {
                case "ADD"-> {
                /*
                    1. get the hash
                    2. add to sortedServerMapping with empty list of req
                    3. get upperbound of hash+1
                    4. get list of req from upperbound val
                    5. find how many req need to be assigned (ones whose upper bound has changed)
                    6. update mapping
                 */

                    int serverHash = userHash(B.get(i), C.get(i));
                    serverMapping.put(B.get(i), serverHash);
                    if(!sortedReqMapping.containsKey(serverHash)) {
                        sortedReqMapping.put(serverHash, new ArrayList<>());
                    } else {
                        output.add(0);
                        continue;
                    }

                    ArrayList<Integer> sortedList = new ArrayList<>(sortedReqMapping.keySet());
                    int upperBound = getUpperbound(sortedList, serverHash+1);
                    ArrayList<String> reqList = sortedReqMapping.get(upperBound);

                    int count = 0;
                    ArrayList<String> toBeRemoved = new ArrayList<>();
                    for(String req: reqList){
                       int reqUpperBound = getUpperbound(sortedList, requestMapping.get(req));
                       if(reqUpperBound != upperBound){
                           toBeRemoved.add(req);
                           count++;

                           sortedReqMapping.get(serverHash).add(req);
                       }
                    }

                    toBeRemoved.forEach(o -> sortedReqMapping.get(upperBound).remove(o));
                    output.add(count);


                }
                case "REMOVE"-> {
                /*
                    1. get the hashValue from serverMapping
                    3. check if any req in list
                    2. if yes. for each req, get the upperbound considering server is removed from list already
                    3. reassign to new location
                 */

                    int serverHashVal = serverMapping.get(B.get(i));
                    ArrayList<String> reqList = sortedReqMapping.get(serverHashVal);

                    if (reqList.isEmpty()) {
                        output.add(0);
                    } else {
                        ArrayList<Integer> sortedList = new ArrayList<>(sortedReqMapping.keySet());
                        sortedList.remove(serverMapping.get(B.get(i)));
                        int upperBound = 0;
                        if(sortedList.isEmpty()){
                            Collection<Integer> values = serverMapping.values();
                            ArrayList<Integer> valueList = new ArrayList<>(values);
                            Collections.sort(valueList);
                            upperBound = getUpperbound(valueList, serverHashVal + 1);
                            sortedReqMapping.put(upperBound, new ArrayList<>());
                        } else {
                            upperBound = getUpperbound(sortedList, serverHashVal + 1);
                            sortedReqMapping.get(upperBound).addAll(reqList);
                        }

                        output.add(reqList.size());
                    }
                    serverMapping.remove(B.get(i));
                    sortedReqMapping.remove(serverHashVal);
                }
                case "ASSIGN"-> {
                /*
                    1. get the hash
                    2. update requestMapping
                    3. get the upperbound and update sortedServerMapping
                 */

                    int reqHash = userHash(B.get(i), C.get(i));
                    requestMapping.put(B.get(i), reqHash);

                    ArrayList<Integer> sortedList = new ArrayList<>(sortedReqMapping.keySet());
                    int upperBound = getUpperbound(sortedList, reqHash);

                    sortedReqMapping.get(upperBound).add(B.get(i));

                    output.add(upperBound);
                }
            }
        }


        return output;
    }

    // method to return upperbound

    static int getUpperbound(ArrayList<Integer> sortedList, int key){
        int n = sortedList.size();
        if(n == 0){
            return -1;
        }
        if(key > sortedList.get(n-1)){
            return sortedList.getFirst();
        }

        /*
            if match return value
            if greater move left [r--]
            if smaller, move right [l++]
         */

        int left = 0, right = n-1;
        int ans = key;
        while (left <= right){
            int mid = (left+right)/2;
            if(sortedList.get(mid) == key){
                return sortedList.get(mid);
            } else if (sortedList.get(mid) > key){
                ans = sortedList.get(mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return ans;
    }
}

package hld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

        List<String> A = List.of("ADD", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN");
        List<String> B = List.of("INDIA", "IRYA", "RGJK", "RUSSIA", "BGVH", "SUKJ", "INDIA", "RBRF");
        List<Integer> C = List.of(11, 31, 7, 3, 5, 13, 23, 17);

        solve1(A, B, C);
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
}

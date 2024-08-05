package ProblemSolving.Graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GoldCoins {

    public static void main(String[] args) {
        // [[1,2],[2,3],[1,4],[3,5],[2,6],[5,7],[2,8]]
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(1,2)));
        B.add(new ArrayList<>(List.of(2,3)));
        B.add(new ArrayList<>(List.of(1,4)));
        B.add(new ArrayList<>(List.of(3,5)));
        B.add(new ArrayList<>(List.of(2,6)));
        B.add(new ArrayList<>(List.of(5,7)));
        B.add(new ArrayList<>(List.of(2,8)));

        // [[6,2],[1,2],[5,7],[2,4],[8,8],[5,8],[2,6],[6,3],[6,2],[4,2]]
        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        C.add(new ArrayList<>(List.of(6,2)));
        C.add(new ArrayList<>(List.of(1,2)));
        C.add(new ArrayList<>(List.of(5,7)));
        C.add(new ArrayList<>(List.of(2,4)));
        C.add(new ArrayList<>(List.of(8,8)));
        C.add(new ArrayList<>(List.of(5,8)));
        C.add(new ArrayList<>(List.of(2,6)));
        C.add(new ArrayList<>(List.of(6,3)));
        C.add(new ArrayList<>(List.of(6,2)));
        C.add(new ArrayList<>(List.of(4,2)));

        // ex 3 2 2 1 4 1 1  ac 1 1 1 1 1 1 1
        ArrayList<Integer> ans = findGoldCoins(8, B, C);
        ans.forEach(System.out::println);
    }

    public static ArrayList<Integer> findGoldCoins(int A, ArrayList<ArrayList<Integer>> B, ArrayList<ArrayList<Integer>> C) {

        List<ArrayList<Integer>> adjList = IntStream.range(0, A+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0,0)))
                .collect(Collectors.toList());

        for (ArrayList<Integer> edge: B){
            int src = edge.get(0);
            int dest = edge.get(1);
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (ArrayList<Integer> travel : C){
            int src = travel.get(0);
            int dest = travel.get(1);
            int min = Math.min(src, dest);
            int max = Math.max(src, dest);
            String path = min+""+max;

            if(map.containsKey(path)){
                map.put(path, map.getOrDefault(path, 0)+1);
            } else {
                if(adjList.get(src).contains(dest)){
                    map.put(path, map.getOrDefault(path, 0)+1);
                } else {
                    // dfs
                    boolean[] visited = new boolean[A+1];
                    dfsTravel(src, -1, dest, map, adjList, visited);

                    // do a bfs from src to dest and increase the coin for each path
//                    Queue<Integer> q = new LinkedList<>();
//                    boolean[] visited = new boolean[A+1];
//                    q.add(src);
//                    visited[src] = true;
//
//                    while (!q.isEmpty()){
//                        int parent = q.poll();
//                        visited[parent] = true;
//
//                        for (int nei: adjList.get(parent)){
//                            int min1 = Math.min(parent, nei);
//                            int max1 = Math.max(parent, nei);
//                            String path1 = min1+""+max1;
//
//                            if(visited[nei]){
//                                map.put(path1, map.getOrDefault(path1, 0)-1);
//                                continue;
//                            } else {
//                                q.add(nei);
//                                visited[nei] = true;
//
//                                map.put(path1, map.getOrDefault(path1, 0)+1);
//                            }
//
//                        }
//                    }
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (ArrayList<Integer> al : B){
            int min = Math.min(al.get(0), al.get(1));
            int max = Math.max(al.get(0), al.get(1));
            ans.add(map.get(min+""+max));
        }

        return ans;
    }

    private static void dfsTravel(int node, int parent, int dest, HashMap<String, Integer> map, List<ArrayList<Integer>> adjList, boolean[] visited) {

        if(visited[node]) {
            int min1 = Math.min(parent, node);
            int max1 = Math.max(parent, node);
            String path1 = min1+""+max1;
            map.put(path1, map.getOrDefault(path1, 0) - 1);
            return;
        }

        if(node == dest){
            return;
        }

        for (Integer nei: adjList.get(node)){
            if(!visited[nei]){
                int min2 = Math.min(node, nei);
                int max2 = Math.max(node, nei);
                String path2 = min2+""+max2;
                map.put(path2, map.getOrDefault(path2, 0) +1);
                visited[nei] = true;
                dfsTravel(nei, node, dest, map, adjList, visited);
            }
        }
    }
}

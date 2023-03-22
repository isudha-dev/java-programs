package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class PathInDirectedGraph {
    public static void main(String[] args) {
        PathInDirectedGraph pg = new PathInDirectedGraph();
        pg.solve(5, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } });
    }

    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B);
        boolean[] visitedArr = new boolean[A + 1];
        Arrays.fill(visitedArr, false);
        DFSTravel(1, visitedArr, adjList);
        if (visitedArr[A]) {
            return 1;
        }
        return 0;
    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int v, int[][] e) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 1; i <= v + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e.length; i++) {
            int src = e[i][0];
            int dest = e[i][1];
            adjList.get(src).add(dest);
        }
        return adjList;
    }

    public void DFSTravel(int v, boolean[] visitedArr, ArrayList<ArrayList<Integer>> adjList) {
        visitedArr[v] = true;
        for (Integer u : adjList.get(v)) {
            if (!visitedArr[u]) {
                DFSTravel(u, visitedArr, adjList);
            }
        }
    }
}

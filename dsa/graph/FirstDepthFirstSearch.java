package dsa.graph;

import java.util.ArrayList;

public class FirstDepthFirstSearch {

    public static void main(String[] args) {
        FirstDepthFirstSearch fs = new FirstDepthFirstSearch();
        fs.solve(new int[] { 1, 1, 1, 3, 3, 4, 6, 5, 3, 3 }, 10, 3);
    }

    public int solve(int[] A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A);
        boolean safeTravel = DFSTravel(C, new boolean[A.length + 1], adjList, B);
        return safeTravel ? 1 : 0;

    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int[] A) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 1; i <= A.length + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i < A.length; i++) {
            int src = A[i];
            int dest = i + 1;
            adjList.get(src).add(dest);
        }
        return adjList;
    }

    public boolean DFSTravel(int v, boolean[] visitedArr, ArrayList<ArrayList<Integer>> adjList, int d) {

        // base case
        if (v == d)
            return true;

        if (adjList.get(v).size() == 0)
            return false;

        visitedArr[v] = true;
        boolean allPath = false;
        for (int u : adjList.get(v)) {
            if (!visitedArr[u]) {
                allPath = allPath || DFSTravel(u, visitedArr, adjList, d);
            }
        }
        return allPath;
    }
}

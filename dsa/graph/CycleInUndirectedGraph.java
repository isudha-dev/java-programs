package dsa.graph;

import java.util.ArrayList;

public class CycleInUndirectedGraph {

    public static void main(String[] args) {
        CycleInUndirectedGraph cy = new CycleInUndirectedGraph();
        int[][] B = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        cy.solve(4, B);
    }

    public int solve(int A, int[][] B) {
        if (A <= 2)
            return 0;

        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B);
        boolean[] visitedArr = new boolean[A + 1];
        for (int i = 1; i <= A; i++) {
            if (!visitedArr[i]) {
                if (isCycleDfs(i, adjList, visitedArr, i)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public boolean isCycleDfs(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visitedArr, int parent) {
        visitedArr[v] = true;
        for (int u : adjList.get(v)) {
            if (u != parent && visitedArr[u]) {
                return true;
            } else if (!visitedArr[u]) {
                if (isCycleDfs(u, adjList, visitedArr, v))
                    return true;
            }
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int v, int[][] e) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i < e.length; i++) {
            int src = e[i][0];
            int dest = e[i][1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        return adjList;
    }

}

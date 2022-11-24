package graph;

import java.util.ArrayList;

public class CyclesInDirectedGraph {

    public static void main(String[] args) {
        CyclesInDirectedGraph cy = new CyclesInDirectedGraph();
        int[][] B = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 1, 4 }, { 4, 3 }, { 4, 5 }, { 3, 5 } };
        cy.solve(5, B);
    }

    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B);
        boolean[] visitedArr = new boolean[A + 1];
        boolean[] inStack = new boolean[A + 1];

        for (int i = 1; i <= A; i++) {
            if (!visitedArr[i]) {
                if (isCycleDfs(i, adjList, visitedArr, inStack) == 1)
                    return 1;
            }
        }
        return 0;
    }

    public int isCycleDfs(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visitedArr, boolean[] inStack) {
        visitedArr[v] = true;
        inStack[v] = true;
        for (int u : adjList.get(v)) {
            if (visitedArr[u] && inStack[u]) {
                inStack[v] = false;
                return 1;
            } else if (!visitedArr[u]) {
                if (isCycleDfs(u, adjList, visitedArr, inStack) == 1) {
                    inStack[v] = false;
                    return 1;
                }
            }
        }
        inStack[v] = false;
        return 0;
    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int v, int[][] e) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e.length; i++) {
            int src = e[i][0];
            int dest = e[i][1];
            adjList.get(src).add(dest);
        }
        return adjList;
    }

}

package dsa.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopologicalSort {

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        ts.solve(8, new int[][] { { 1, 4 }, { 1, 2 }, { 4, 2 }, { 4, 3 }, { 3, 2 }, { 5, 2 }, { 3, 5 }, { 8, 2 },
                { 8, 6 } });
    }

    public int[] solve(int A, int[][] B) {
        int orderArr[] = new int[A];
        int indegree[] = new int[A + 1];

        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B);

        for (int i = 0; i < B.length; i++) {
            int u = B[i][1];
            indegree[u]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int numVisited = 0;
        int idx = 0;
        while (!q.isEmpty()) {
            int top = q.remove();
            orderArr[idx] = top;
            idx++;
            numVisited++;
            for (int u : adjList.get(top)) {
                indegree[u]--;
                if (indegree[u] == 0)
                    q.add(u);
            }
        }
        if (numVisited != A)
            return new int[] {};

        return orderArr;

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

}

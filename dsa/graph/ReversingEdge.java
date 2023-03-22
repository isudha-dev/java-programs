package dsa.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReversingEdge {

    public static void main(String[] args) {
        ReversingEdge re = new ReversingEdge();
        re.reverseEdges(5, new int[][] { { 1, 2 }, { 2, 3 }, { 4, 3 }, { 4, 5 } });
    }

    // here we will use single source shortest path. For given edges in input will
    // be give weight of 0 and add opposite edge with weight 1. This will give us
    // shortest path to reach last node, reversed edge will amount of cost.

    public int reverseEdges(int A, int[][] B) {
        ArrayList<ArrayList<Pair>> adjList = createAdjacencyList(A, B);
        boolean[] visitedArr = new boolean[A + 1];
        int[] distArr = new int[A + 1];

        for (int i = 0; i < A + 1; i++)
            distArr[i] = Integer.MAX_VALUE;
        distArr[1] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b) -> a.wt - b.wt);
        q.add(new Pair(1, 0));

        while (!q.isEmpty()) {
            Pair pair = q.remove();
            int u = pair.v;
            if (visitedArr[u])
                continue;
            visitedArr[u] = true;
            for (Pair p : adjList.get(u)) {
                int v = p.v;
                if (visitedArr[v])
                    continue;

                int wt = p.wt;
                int newWt = distArr[u] + wt;

                if (!visitedArr[v] && newWt < distArr[v]) {
                    distArr[v] = newWt;
                    q.add(new Pair(v, distArr[v]));
                }
            }
        }
        return distArr[A] == Integer.MAX_VALUE ? -1 : distArr[A];
    }

    class Pair {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public ArrayList<ArrayList<Pair>> createAdjacencyList(int A, int[][] B) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 1; i <= A + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            int src = B[i][0];
            int dest = B[i][1];
            adjList.get(src).add(new Pair(dest, 0)); // adding original edge with weight 0
            adjList.get(dest).add(new Pair(src, 1)); // adding opposite edge of weight 1
        }
        return adjList;
    }

}

package dsa.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras {

    public static void main(String[] args) {
        Dijkstras ds = new Dijkstras();
        int[][] B = new int[][] { { 0, 4, 9 }, { 3, 4, 6 }, { 1, 2, 1 }, { 2, 5, 1 }, { 2, 4, 5 }, { 0, 3, 7 },
                { 0, 1, 1 }, { 4, 5, 7 }, { 0, 5, 1 } };
        ds.solve(6, B, 4);
    }

    public int[] solve(int A, int[][] B, int C) {
        ArrayList<ArrayList<PairVertexWeight>> adjList = createAdjacencyList(A, B);
        boolean[] visitedArr = new boolean[A];
        int[] distArr = new int[A];

        for (int i = 0; i < A; i++)
            distArr[i] = Integer.MAX_VALUE;
        distArr[C] = 0;

        PriorityQueue<PairVertexDist> q = new PriorityQueue<>((PairVertexDist a, PairVertexDist b) -> a.dist - b.dist);
        q.add(new PairVertexDist(C, 0));

        while (!q.isEmpty()) {
            PairVertexDist pair = q.remove();
            int u = pair.v;
            if (visitedArr[u])
                continue;
            visitedArr[u] = true;
            for (PairVertexWeight p : adjList.get(u)) {
                int v = p.v;
                int wt = p.wt;
                int newWt = distArr[u] + wt;
                if (!visitedArr[v] && newWt < distArr[v]) {
                    distArr[v] = newWt;
                    q.add(new PairVertexDist(v, distArr[v]));
                }
            }
        }

        for (int i = 0; i < A; i++)
            if (distArr[i] == Integer.MAX_VALUE) {
                distArr[i] = -1;
            }
        return distArr;
    }

    public ArrayList<ArrayList<PairVertexWeight>> createAdjacencyList(int v, int[][] e) {
        ArrayList<ArrayList<PairVertexWeight>> adjList = new ArrayList<>();
        for (int i = 1; i <= v + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e.length; i++) {
            int src = e[i][0];
            int dest = e[i][1];
            int wt = e[i][2];
            adjList.get(src).add(new PairVertexWeight(dest, wt));
            adjList.get(dest).add(new PairVertexWeight(src, wt)); // undirected dsa.graph
        }
        return adjList;
    }

    class PairVertexDist {
        int v;
        int dist;

        PairVertexDist(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    class PairVertexWeight {
        int v;
        int wt;

        PairVertexWeight(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }
}

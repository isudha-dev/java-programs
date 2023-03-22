package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteGraph {

    public static void main(String[] args) {
        CheckBipartiteGraph bi = new CheckBipartiteGraph();
        int[][] B = { { 45, 2 }, { 11, 68 }, { 4, 76 }, { 29, 78 }, { 14, 59 }, { 2, 92 }, { 17, 81 }, { 16, 48 },
                { 20, 93 }, { 71, 93 }, { 74, 78 }, { 19, 67 }, { 11, 48 }, { 19, 71 }, { 0, 87 }, { 39, 75 },
                { 32, 72 }, { 52, 89 }, { 1, 95 }, { 61, 77 }, { 34, 94 }, { 48, 66 }, { 9, 39 }, { 21, 30 }, { 1, 68 },
                { 15, 76 }, { 22, 88 }, { 64, 94 }, { 43, 51 }, { 22, 29 }, { 10, 76 }, { 59, 78 }, { 25, 28 },
                { 92, 94 }, { 11, 52 }, { 28, 78 }, { 27, 90 }, { 30, 71 }, { 15, 30 }, { 14, 78 }, { 35, 68 },
                { 32, 91 }, { 10, 46 }, { 60, 79 }, { 11, 58 }, { 0, 16 } };

        bi.solveBFS(96, B);
    }

    public int solveDFS(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B);
        int[] colorArr = new int[A];
        Arrays.fill(colorArr, -1);
        for (int i = 0; i < A; i++) {
            if (colorArr[i] == -1) {
                if (!isBipartiteDFS(i, adjList, 0, colorArr))
                    return 0;
            }
        }
        return 1;
    }

    public int solveBFS(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B);
        int[] colorArr = new int[A];
        Arrays.fill(colorArr, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < A; i++) {
            if (colorArr[i] == -1) {
                q.add(i);
                colorArr[i] = 0;
                while (!q.isEmpty()) {
                    int top = q.poll();
                    for (int u : adjList.get(top)) {
                        if (colorArr[u] == -1) {
                            colorArr[u] = 1 - colorArr[top];
                            q.add(u);
                        } else if (colorArr[u] == colorArr[top])
                            return 0;
                    }
                }
            }
        }

        return 1;
    }

    public boolean isBipartiteDFS(int v, ArrayList<ArrayList<Integer>> adjList, int nodeColor, int[] colorArr) {
        colorArr[v] = nodeColor;
        for (Integer u : adjList.get(v)) {
            if (colorArr[u] == -1) {
                if (!isBipartiteDFS(u, adjList, 1 - nodeColor, colorArr)) {
                    return false;
                }
            } else if (colorArr[u] == nodeColor)
                return false;
        }
        return true;
    }

    public boolean isBipartiteBFS(int v, ArrayList<ArrayList<Integer>> adjList, int nodeColor, int[] colorArr) {
        colorArr[v] = nodeColor;
        for (Integer u : adjList.get(v)) {
            if (colorArr[u] == -1) {
                if (!isBipartiteBFS(u, adjList, 1 - nodeColor, colorArr)) {
                    return false;
                }
            } else if (colorArr[u] == nodeColor)
                return false;
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int v, int[][] e) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e.length; i++) {
            int src = e[i][0];
            int dest = e[i][1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        return adjList;
    }

}

package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructRoads {

    public static void main(String[] args) {
        ConstructRoads cr = new ConstructRoads();
        int[][] B = { { 2, 1 } };

        cr.solve(2, B);
    }

    public int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B);
        int[] colorArr = new int[A + 1];
        Arrays.fill(colorArr, -1);

        Queue<Integer> q = new LinkedList<>();
        long count[] = new long[2];
        for (int i = 1; i <= A; i++) {
            if (colorArr[i] == -1) {
                q.add(i);
                colorArr[i] = 0;
                count[0]++;
                while (!q.isEmpty()) {
                    int top = q.poll();
                    for (int u : adjList.get(top)) {
                        if (colorArr[u] == -1) {
                            int newColor = 1 - colorArr[top];
                            colorArr[u] = newColor;
                            count[newColor]++;
                            q.add(u);
                        } else if (colorArr[u] == colorArr[top])
                            return 0;
                    }
                }
            }
        }

        int mod = 1000000007;
        long maxRoads = (long) (count[0] * count[1]) % mod;
        int existingRoads = B.length;
        long newRoads = maxRoads - existingRoads;

        return (int) newRoads;
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
            adjList.get(dest).add(src);
        }
        return adjList;
    }
}

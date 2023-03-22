package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PossibilityOfFinishingCourse {

    public static void main(String[] args) {
        PossibilityOfFinishingCourse ps = new PossibilityOfFinishingCourse();
        int A = 2;
        int[] B = new int[] { 1, 2, 3 };
        int[] C = new int[] { 2, 3, 1 };
        ps.solve(A, B, C);
    }

    public int solve(int A, int[] B, int[] C) {
        int indegree[] = new int[A + 1];

        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(A, B, C);

        for (int i = 0; i < C.length; i++) {
            int u = C[i];
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int numVisited = 0;
        while (!q.isEmpty()) {
            int top = q.remove();
            numVisited++;
            for (int u : adjList.get(top)) {
                indegree[u]--;
                if (indegree[u] == 0)
                    q.add(u);
            }
        }
        if (numVisited != A)
            return 0;

        return 1;
    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int A, int[] B, int[] C) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 1; i <= A + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            int src = B[i];
            int dest = C[i];
            adjList.get(src).add(dest);
        }
        return adjList;
    }

}

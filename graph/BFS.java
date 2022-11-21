package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void bfsTravel(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visitedArr) {

        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visitedArr[v] = true;
        while (!q.isEmpty()) {
            int top = q.poll();
            System.out.println(top);
            for (int u : adjList.get(v)) {
                if (!visitedArr[u]) {
                    visitedArr[u] = true;
                    q.add(u);
                }
            }
        }
    }

}

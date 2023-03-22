package dsa.graph;

import java.util.ArrayList;

public class DFS {

    public void DFSTravel(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visitedArr) {
        visitedArr[v] = true;
        for (Integer u : adjList.get(v)) {
            if (!visitedArr[u]) {
                DFSTravel(u, adjList, visitedArr);
            }
        }
    }
}

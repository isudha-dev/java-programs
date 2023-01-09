package graph;

import java.util.ArrayList;

public class MakeCircle {

    public int solve(String[] A) {
        int[] indegree = new int[26];
        int[] outdegree = new int[26];
        boolean[] visited = new boolean[26];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            int src = s.charAt(0) - 'a';
            int dest = s.charAt(s.length() - 1) - 'a';

            indegree[dest]++;
            outdegree[src]++;

            // visited[src] = visited[dest] = true;

            adj.get(src).add(dest);
        }

        for (int i = 0; i < 26; i++) {
            if (indegree[i] != outdegree[i])
                return 0;
        }

        dfs(adj, visited, A[0].charAt(0) - 'a');

        for (int i = 0; i < 26; i++) {
            if (adj.get(i).size() > 0 && !visited[i])
                return 0;
        }

        return 0;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;
        for (int u : adj.get(src)) {
            if (!visited[u])
                dfs(adj, visited, u);
        }
    }

}

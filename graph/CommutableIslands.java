package graph;

import java.util.ArrayList;
import java.util.List;

public class CommutableIslands {

    public int solve(int A, int[][] B) {
        List<Node> adjList = new ArrayList<>();
        int bLen = B.length;
        int totalWeight = 0;
        int[] Parent = new int[A + 1];

        // initially each node is parent of itself
        for (int i = 1; i < Parent.length; i++) {
            Parent[i] = i;
        }

        // filling up the adjacency list
        for (int i = 0; i < bLen; i++) {
            Node n = new Node(B[i][0], B[i][1], B[i][2]);
            adjList.add(n);
        }

        // sort adjacency List based on weight
        adjList.sort((o1, o2) -> o1.w - o2.w);

        // loop through sorted adjacency list and extract vertices u, v and weights.
        // Find the parent of u and v,
        // if they belong to diff parent consider taking that edge (Union) and replace
        // the parent of higher node
        // with smaller node's parent.
        for (int i = 0; i < bLen; i++) {
            Node node = adjList.get(i);
            int u = node.u;
            int v = node.v;
            int w = node.w;

            int Parent_U = findParent(u, Parent);
            int Parent_V = findParent(v, Parent);

            if (Parent_U != Parent_V) {
                Parent[Math.max(Parent_U, Parent_V)] = Parent[Math.min(Parent_U, Parent_V)];
                totalWeight += w;
            }
        }

        return totalWeight;
    }

    int findParent(int node, int[] Parent) {
        if (node == Parent[node]) {
            return node;
        }

        Parent[node] = findParent(Parent[node], Parent);

        return Parent[node];
    }

    class Node {
        int u;
        int v;
        int w;

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

}

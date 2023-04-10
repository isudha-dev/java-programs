package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestColorValInDirGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int len = colors.length();
        int alpha = 26;
        int[] inDegrees = new int[len];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegrees[edge[1]]++;
        }
        Set<Integer> zeroInDegree = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (inDegrees[i] == 0) {
                zeroInDegree.add(i);
            }
        }
        int[][] counts = new int[len][alpha];
        for (int i = 0; i < len; i++) {
            counts[i][colors.charAt(i) - 'a']++;
        }
        int maxCount = 0;
        int visited = 0;
        while (!zeroInDegree.isEmpty()) {
            int u = zeroInDegree.iterator().next();
            zeroInDegree.remove(u);
            visited++;
            for (int v : graph.get(u)) {
                for (int i = 0; i < alpha; i++) {
                    counts[v][i] = Math.max(counts[v][i], counts[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0));
                }
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    zeroInDegree.add(v);
                }
            }
            maxCount = Math.max(maxCount, Arrays.stream(counts[u]).max().getAsInt());
        }
        return visited == len ? maxCount : -1;
    }

}

package dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
  public static void main(String[] args) {
    CloneGraph cg = new CloneGraph();
    UndirectedGraphNode node1 = new UndirectedGraphNode(1);
    UndirectedGraphNode node2 = new UndirectedGraphNode(2);
    UndirectedGraphNode node3 = new UndirectedGraphNode(3);
    UndirectedGraphNode node4 = new UndirectedGraphNode(4);
    UndirectedGraphNode node5 = new UndirectedGraphNode(5);
    UndirectedGraphNode node6 = new UndirectedGraphNode(6);
    UndirectedGraphNode node7 = new UndirectedGraphNode(7);
    ArrayList<UndirectedGraphNode> nbr = new ArrayList<>();
    nbr.add(node3);
    nbr.add(node4);
    node1.neighbors = nbr;
    nbr = new ArrayList<>();
    nbr.add(node2);
    node3.neighbors = nbr;
    nbr = new ArrayList<>();
    nbr.add(node5);
    nbr.add(node6);
    nbr.add(node7);
    node4.neighbors = nbr;

    cg.cloneGraph(node1);

  }

  HashMap<UndirectedGraphNode, UndirectedGraphNode> visitedMap = new HashMap<>();

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null)
      return node;

    if (visitedMap.containsKey(node))
      return visitedMap.get(node);

    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    visitedMap.put(node, newNode);
    for (UndirectedGraphNode nbr : node.neighbors) {
      newNode.neighbors.add(cloneGraph(nbr));
    }
    return newNode;
  }
  static class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<UndirectedGraphNode>();
    }
  };
}


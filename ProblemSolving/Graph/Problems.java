package ProblemSolving.Graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problems {

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {

        List<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(1,2)));
        edges.add(new ArrayList<>(List.of(1,5)));
        edges.add(new ArrayList<>(List.of(2,3)));
        edges.add(new ArrayList<>(List.of(1,3)));
        edges.add(new ArrayList<>(List.of(3,4)));
        edges.add(new ArrayList<>(List.of(5,4)));
        edges.add(new ArrayList<>(List.of(5,6)));
        edges.add(new ArrayList<>(List.of(6,4)));

        int n = 6;
        List<ArrayList<Integer>> adjList = IntStream.range(0, n+1)
                        .mapToObj(i -> new ArrayList<>(Collections.nCopies(0,0)))
                                .collect(Collectors.toList());

        for(ArrayList<Integer> list: edges){
            int src = list.get(0);
            int dest = list.get(1);

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        secondShortestPathFromSingleSource(n, adjList, 3, 4);

//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(List.of(1, 2, 14)));
//        A.add(new ArrayList<>(List.of(2, 3, 7)));
//        A.add(new ArrayList<>(List.of(3, 1, 2)));
//        A.add(new ArrayList<>(List.of(0, 3, 4)));
//        A.add(new ArrayList<>(List.of(2, 3, 3)));
//        A.add(new ArrayList<>(List.of(0, 1, 9)));
//        A.add(new ArrayList<>(List.of(3, 4, 10)));
//        A.add(new ArrayList<>(List.of(1, 3, 8)));
//        A.add(new ArrayList<>(List.of(0, 3, 7)));
//        A.add(new ArrayList<>(List.of(0, 1, 1)));
//        A.add(new ArrayList<>(List.of(4, 5, 7)));
//        A.add(new ArrayList<>(List.of(0, 5, 1)));

//        System.out.println(constructionCost(6, A));


        // e 1 4 3 5 7 8 2 6
        // a 1 7 8 4 6 3 5 2
        // 8 [[1,4],[1,2],[4,2],[4,3],[3,2],[5,2],[3,5],[8,2],[8,6]]

//        ArrayList<Integer> B = new ArrayList<>(List.of(1,3,4,5));
//        ArrayList<Integer> C = new ArrayList<>(List.of(2,1,5,3));
//
//        System.out.println( possibilityOfFinishingCourse(5, B, C));
//        distOfNearestCell(B);

//        System.out.println( validPath(41,67,5,0, new ArrayList<>(List.of(17,16,12,0,40)), new ArrayList<>(List.of(52,61,61,25,31))));

        // [[1,2],[2,3],[3,1],[2,4],[2,5],[2,7],[4,6],[5,6]]
        // e 1 a 0
        // [[6,45],[29,81],[7,8],[67,76],[40,76],[7,73],[9,20],[56,63],[52,57],[22,31],[26,76],[14,58],[31,69],[30,31],[56,85],[22,57],[12,42],[19,78],[12,85],[72,85],[3,41],[32,87],[31,48],[17,81],[2,63],[25,78],[49,51],[30,61],[7,54],[79,80],[23,37],[25,32],[54,63],[7,28],[41,58],[45,52],[77,78],[26,53],[54,83],[26,75],[61,72],[57,82],[9,36],[30,73],[12,17],[24,55],[47,68],[12,64],[35,77],[33,86],[2,50],[17,41],[27,70],[7,43],[62,73],[3,60],[49,58],[32,52],[26,73],[13,78],[8,68],[17,68],[34,51],[48,51],[8,11],[31,78],[22,53],[2,64],[71,80],[11,81],[86,88],[9,67],[6,18],[40,53],[52,77],[21,52],[47,71],[48,50],[16,76],[16,86],[3,71],[10,59],[33,73],[52,68],[24,66],[32,72],[3,4],[34,35],[57,76],[25,33],[20,59],[29,44],[50,56],[41,82],[25,85],[17,35],[34,52],[62,68],[5,26],[13,39],[25,56],[5,12],[85,87],[20,86],[63,80],[6,53],[28,78],[47,65],[28,64],[7,51],[41,59]]
        // 88

//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(List.of(1,2)));
//        A.add(new ArrayList<>(List.of(2,3)));
//        A.add(new ArrayList<>(List.of(3,1)));
//        A.add(new ArrayList<>(List.of(2,4)));
//        A.add(new ArrayList<>(List.of(2,5)));
//        A.add(new ArrayList<>(List.of(2,7)));
//        A.add(new ArrayList<>(List.of(4,6)));
//        A.add(new ArrayList<>(List.of(5,6)));
        /*
            1: 2 3
            2: 1 3 4 5 7
            3: 1 2
            4: 6 2
            5: 6 2
            6: 4 5
            7: 2
         */
//        System.out.println(cycleInUndirectedGraph(2, A));

        // [[7,8],[1,2],[0,9],[1,3],[6,7],[0,3],[2,5],[3,8],[4,8]]
        // [[2,5],[6,7],[4,8],[2,3],[0,3],[4,7],[1,8],[3,8],[1,3]]
//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(List.of(2, 5)));
//        A.add(new ArrayList<>(List.of(6,7)));
//        A.add(new ArrayList<>(List.of(4,8)));
//        A.add(new ArrayList<>(List.of(2,3)));
//        A.add(new ArrayList<>(List.of(0,3)));
//        A.add(new ArrayList<>(List.of(4,7)));
//        A.add(new ArrayList<>(List.of(1,8)));
//        A.add(new ArrayList<>(List.of(3,8)));
//        A.add(new ArrayList<>(List.of(1,3)));

//        System.out.println( bipartiteGraph(A.size(), A));
        /*

            0: 9, 3
            1: 2, 3
            2: 5
            3: 8
            4: 8
            6: 7
            7: 8

            9 3 2 4 7
            0 1 5 8 6

         */
//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(List.of(2, 1, 1)));
//        A.add(new ArrayList<>(List.of(1, 1, 0)));
//        A.add(new ArrayList<>(List.of(0, 1, 1)));
//
//        System.out.println(rottenOranges(A));

//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(List.of(0,0,1,0,1,0,1,1,1)));
//        A.add(new ArrayList<>(List.of(0,1,0,0,1,1,1,0,1)));
//        System.out.println(numOfIslands(A));

//        ArrayList<Integer> A = new ArrayList<>(List.of(1,1,1,3,3,2,2,7,6));
//        System.out.println(firstDepthFirstSearch(A, 9, 1));

//        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
//        B.add(new ArrayList<>(List.of(1,2)));
//        B.add(new ArrayList<>(List.of(4,3)));
//        B.add(new ArrayList<>(List.of(2,4)));
//        B.add(new ArrayList<>(List.of(3,5)));
//        B.add(new ArrayList<>(List.of(5,2)));
//        B.add(new ArrayList<>(List.of(1,3)));
//
//        System.out.println(pathFrom1ToAInDirectedGraph(5, B));
    }

    public static int secondShortestPathFromSingleSource (int n, List<ArrayList<Integer>> adjList, int src, int dest){
        int[] freq = new int[n+1];
        int[] distance1 = new int[n+1];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        int[] distance2 = new int[n+1];
        Arrays.fill(distance2, Integer.MAX_VALUE);

        distance1[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});

        while (!q.isEmpty()){
            int[] top = q.poll();
            int node = top[0];
            int time = top[1];

            if(node == dest && freq[node] == 2){
                return time;
            }

            freq[node]++;
            time++;

            for (Integer nei: adjList.get(node)){
                if(freq[nei] == 2){
                    continue;
                }
                if(distance1[nei] > time){
                    distance2[nei] = distance1[nei];
                    distance1[nei] = time;
                    q.add(new int[] {nei, time});
                } else if(distance2[nei] > time && distance1[nei] != time) {
                    distance2[nei] = time;
                    q.add(new int[] {nei, time});
                }
            }
        }
        return distance2[dest];
    }

    public static void findBridges(int n, List<ArrayList<Integer>> edges){

        List<ArrayList<Integer>> adjList = IntStream.range(0, n+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, 0)))
                .collect(Collectors.toList());

        for(ArrayList<Integer> list: edges) {
            int src = list.get(0);
            int dest = list.get(1);
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        List<ArrayList<Integer>> bridges = new ArrayList<>();
        // for each bridge check if there is another path to make those 2 nodes connected

        for(ArrayList<Integer> list: edges){
            boolean[] visited = new boolean[n+1];
            int src = list.get(0);
            int dest = list.get(1);

            int pathCount = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(src);

            while (!q.isEmpty()){
                int top = q.poll();
                if(top == dest && pathCount > 1){
                    visited[top] = true;
                    break;
                }
                if(top == dest && pathCount == 1){
                    continue;
                }
                pathCount++;
                visited[top] = true;

                for (Integer nei: adjList.get(src)){
                    if(visited[nei]){
                        continue;
                    }
                    q.add(nei);
                }
            }

            if (visited[dest]){
                bridges.add(new ArrayList<>(List.of(src, dest)));
            }
        }
        System.out.println(bridges);
    }

    public static int constructionCost(int A, ArrayList<ArrayList<Integer>> B) {
        // prims algo
        List<ArrayList<Pair>> adjList = IntStream.range(0, A)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, new Pair(0,0))))
                .collect(Collectors.toList());

        for(ArrayList<Integer> list: B){
            int src = list.get(0);
            int dest = list.get(1);
            int wt = list.get(2);
            adjList.get(src).add(new Pair(dest, wt));
            adjList.get(dest).add(new Pair(src, wt));
        }

        boolean[] visited = new boolean[A];
        int ans = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.b));
        pq.add(new Pair(1, 0));

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int p_node = top.a;
            int p_wt = top.b;

            if(visited[p_node]){
                continue;
            }

            visited[p_node] = true;
            ans += p_wt;

            for(Pair child: adjList.get(p_node)){
                int c_node = child.a;
                int c_wt = child.b;
                if(!visited[c_node])
                    pq.add(new Pair(c_node, c_wt));
            }

        }
        return ans;
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    static HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null)
            return node;

        if(visited.containsKey(node))
            return visited.get(node);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(node, newNode);
        for (UndirectedGraphNode nbr: node.neighbors){
            newNode.neighbors.add(cloneGraph(nbr));
        }
        return newNode;
    }

    public static int reversingEdges(int A, ArrayList<ArrayList<Integer>> B) {

        List<ArrayList<Pair>> adjList = IntStream.range(0, A+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, new Pair(0, 0))))
                .collect(Collectors.toList());

        for (ArrayList<Integer> list: B) {
            int src = list.get(0);
            int dest = list.get(1);
            adjList.get(src).add(new Pair(dest, 0));
            adjList.get(dest).add(new Pair(src, 1));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.b));
        boolean[] visited = new boolean[A+1];
        queue.add(new Pair(1, 0));

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(A,Integer.MAX_VALUE));
        ans.set(1, 0);

        while (!queue.isEmpty()){
            Pair top = queue.poll();
            int parent_node = top.a;
            if(visited[parent_node]){
                continue;
            }
            visited[parent_node] = true;

            for (Pair child : adjList.get(parent_node)) {
                int child_node = child.a;
                if(visited[child_node]){
                    continue;
                }
                int child_wt = child.b;
                int new_wt = ans.get(parent_node) + child_wt;
                if(!visited[child_node] && new_wt < ans.get(child_node)){
                    ans.set(child_node, new_wt);
                    queue.add(new Pair(child_node, new_wt));
                }
            }
        }

        return ans.get(A) == Integer.MAX_VALUE ? -1 : ans.get(A);
    }

    public static ArrayList<Integer> dijkstra(int A, ArrayList<ArrayList<Integer>> B, int C) {

        List<ArrayList<Pair>> adjList = IntStream.range(0, A)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, new Pair(0, 0))))
                .collect(Collectors.toList());

        for (ArrayList<Integer> list: B) {
            int src = list.get(0);
            int dest = list.get(1);
            int weight = list.get(2);
            adjList.get(src).add(new Pair(dest, weight));
            adjList.get(dest).add(new Pair(src, weight));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.b));
        boolean[] visited = new boolean[A];
        queue.add(new Pair(C, 0));

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(A,Integer.MAX_VALUE));
        ans.set(C, 0);

        while (!queue.isEmpty()){
            Pair top = queue.poll();
            int parent_node = top.a;

            if(visited[parent_node]){
                continue;
            }
            visited[parent_node] = true;

            for (Pair child : adjList.get(parent_node)) {
                int child_node = child.a;
                int child_wt = child.b;
                int new_wt = ans.get(parent_node) + child_wt;
                if(!visited[child_node] && new_wt < ans.get(child_node)){
                    ans.set(child_node, new_wt);
                    queue.add(new Pair(child_node, new_wt));
                }
            }
        }

        ans.replaceAll(val -> val == Integer.MAX_VALUE ? -1 : val);

        return ans;
    }

    public static int possibilityOfFinishingCourse(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        List<ArrayList<Integer>> adjList = IntStream.range(0, A+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, 0)))
                .collect(Collectors.toList());

        for (int i = 0; i <B.size(); i++) {
            adjList.get(B.get(i)).add(C.get(i));
        }

        int[] indegree = new int[A+1];
        C.forEach(i -> indegree[i]++);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<indegree.length; i++){
            if(indegree[i] == 0)
                q.add(i);
        }
//        Arrays.stream(indegree).filter(i -> i == 0).forEach(i -> q.add(i));


        int numVisited = 0;
        while (!q.isEmpty()){
            int top = q.poll();
            numVisited++;
            for (int i: adjList.get(top)){
                indegree[i]--;
                if (indegree[i] == 0)
                    q.add(i);
            }
        }

        return numVisited != A ? 0 : 1;

    }

    public static ArrayList<Integer> toposort(int A, ArrayList<ArrayList<Integer>> B) {
        List<ArrayList<Integer>> adjList = IntStream.range(0, A+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, 0)))
                .collect(Collectors.toList());

        B.forEach(i -> adjList.get(i.get(0)).add(i.get(1)));

        int[] indegree = new int[A+1];

        for(ArrayList<Integer> list: B){
            indegree[list.get(1)]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 1; i<=A; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);
            for(int i: adjList.get(top)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return ans;

    }

    public static ArrayList<ArrayList<Integer>> distOfNearestCell(ArrayList<ArrayList<Integer>> A) {

        List<ArrayList<Integer>> ansList = IntStream.range(0, A.size())
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(A.get(0).size(), Integer.MAX_VALUE)))
                .collect(Collectors.toList());

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[A.size()][A.get(0).size()];

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if(A.get(i).get(j) == 1){
                    ansList.get(i).set(j, 0);
                    queue.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int[] rows = {0, 0, 1, -1};
        int[] cols = {1, -1, 0, 0};

        while (!queue.isEmpty()){
            Pair top = queue.poll();
            int r = top.a;
            int c = top.b;
            int parentVal = ansList.get(r).get(c);

            for (int v = 0; v < 4; v++) {
                int rN = r + rows[v];
                int cN = c + cols[v];

                if(rN >= 0 && rN < A.size() && cN >= 0 && cN < A.get(0).size() && !visited[rN][cN]){
                    visited[rN][cN] = true;
                    queue.add(new Pair(rN, cN));
                    ansList.get(rN).set(cN, Math.min(ansList.get(rN).get(cN), parentVal+1));
                }
            }
        }


        return (ArrayList<ArrayList<Integer>>) ansList;
    }

    public static String validPath(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {

        int[] rows = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] cols = {1, 1, 0, -1, -1, -1, 0, 1};

        boolean[][] visited = new boolean[A+1][B+1];
        Queue<Pair> q = new LinkedList<>();
        if(isPointInsideCircle(D, E, F, 0, 0)){
            return "NO";
        }
        q.add(new Pair(0,0));
        visited[0][0] = true;

        while (!q.isEmpty()){
            Pair top = q.poll();
            int x = top.a;
            int y = top.b;

            for (int i = 0; i < 8; i++) {
                int xN = x+rows[i];
                int yN = y+cols[i];
                boolean isPointInside = isPointInsideCircle(D, E, F, xN, yN);

                if(xN == A && yN == B && !isPointInside){
                    return "YES";
                }
                if(xN >= 0 && xN <= A && yN >= 0 && yN <= B && !visited[xN][yN] && !isPointInside){
                    visited[xN][yN] = true;
                    q.add(new Pair(xN, yN));
                }
            }

        }

        return "NO";
    }

    public static boolean isPointInsideCircle(int r, ArrayList<Integer> E, ArrayList<Integer> F, int x, int y){

        for (int i = 0; i < E.size(); i++) {
            int a = E.get(i);
            int b = F.get(i);

            if(a == x && b == y) {
                return true;
            }

            if( ((x-a) * (x-a)) + ((y-b) * (y-b)) <= r*r){
                return true;
            }
        }
        return false;
    }

    public static int cycleInUndirectedGraph(int A, ArrayList<ArrayList<Integer>> B) {
        // 1 to A nodes

        List<ArrayList<Integer>> adjList = IntStream.range(0, A+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0,0)))
                .collect(Collectors.toList());

        B.forEach(a -> adjList.get(a.get(0)).add(a.get(1)));
        B.forEach(a -> adjList.get(a.get(1)).add(a.get(0)));

        boolean[] visited = new boolean[A+1];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 1; i <= A; i++) {
            if(!visited[i]){
                queue.add(new Pair(i, -1));
                visited[i] = true;

                while(!queue.isEmpty()){
                    Pair top = queue.poll();
                    for(int child: adjList.get(top.a)){
                        if(!visited[child]){
                            visited[child] = true;
                            queue.add(new Pair(child, top.a));
                        } else if (child != top.b) {
                            return 1;
                        }
                    }
                }
            }

        }


        return 0;
    }


    public static int constructRoads(int A, ArrayList<ArrayList<Integer>> B) {

        int[] colorMatrix = new int[A+1];
        Arrays.fill(colorMatrix, -1);

        List<ArrayList<Integer>> adjList = IntStream.range(0, A+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, 0)))
                .collect(Collectors.toList());

        B.forEach(a -> adjList.get(a.get(0)).add(a.get(1)));
        B.forEach(a -> adjList.get(a.get(1)).add(a.get(0)));

        long[] count = new long[2];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= A; i++) {
            if(colorMatrix[i] == -1) {
                q.add(i);
                colorMatrix[i] = 0;
                count[0]++;

                while (!q.isEmpty()){
                    int ix = q.poll();
                    for(int j: adjList.get(ix)){
                        if(colorMatrix[j] == -1) {
                            q.add(j);
                            int newColor = 1 - colorMatrix[ix];
                            colorMatrix[j] = newColor;
                            count[newColor]++;
                        }
                        else {
                            if (colorMatrix[j] == colorMatrix[ix])
                                return 0;
                        }
                    }
                }
            }
        }

        int mod = 1000000007;
        long maxRoads = (count[0] * count[1]) % mod;
        int existingRoads = B.size();
        long newRoads = maxRoads - existingRoads;

        return (int) newRoads;
    }

    public static int bipartiteGraph(int A, ArrayList<ArrayList<Integer>> B) {
        int[] colorMatrix = new int[A];
        Arrays.fill(colorMatrix, -1);

        List<ArrayList<Integer>> adjList = IntStream.range(0, A)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0, 0)))
                .collect(Collectors.toList());

        B.forEach(a -> adjList.get(a.get(0)).add(a.get(1)));
        B.forEach(a -> adjList.get(a.get(1)).add(a.get(0)));

        Queue<Integer> q = new LinkedList<>();


        for (int i = 0; i < A; i++) {
            if(colorMatrix[i] == -1) {
                q.add(i);
                colorMatrix[i] = 0;

                while (!q.isEmpty()){
                    int ix = q.poll();
                    for(int j: adjList.get(ix)){
                        if(colorMatrix[j] == -1) {
                            q.add(j);
                            colorMatrix[j] = 1 - colorMatrix[ix];
                        }
                        else {
                            if (colorMatrix[j] == colorMatrix[ix])
                                return 0;
                        }
                    }
                }
            }
        }


        return 1;
    }

    public static int rottenOranges(ArrayList<ArrayList<Integer>> A) {
        List<ArrayList<Integer>> ansMatrix = IntStream.range(0, A.size())
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(A.get(0).size(), Integer.MAX_VALUE)))
                .toList();


        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i<A.size(); i++){
            for (int j = 0; j < A.get(0).size(); j++) {
                if(A.get(i).get(j) == 2) {
                    queue.add(new Pair(i, j));
                    ansMatrix.get(i).set(j, 0);
                }
            }
        }

        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        while (!queue.isEmpty()){
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = p.a + rows[i];
                int c = p.b + cols[i];

                if(r >= 0 && r < A.size() && c >= 0 && c < A.get(0).size() && A.get(r).get(c) == 1 && ansMatrix.get(r).get(c) == Integer.MAX_VALUE){
                    ansMatrix.get(r).set(c,ansMatrix.get(p.a).get(p.b) + 1);
                    queue.add(new Pair(r,c));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if(A.get(i).get(j) == 1) {
                    max = Math.max(max, ansMatrix.get(i).get(j));
                }
            }
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public static int numOfIslands(ArrayList<ArrayList<Integer>> A) {
        boolean[][] visited = new boolean[A.size()][A.get(0).size()];

        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if(A.get(i).get(j) == 1 && !visited[i][j]){
                    count++;
                    dfsTravelNumOfIsland(i, j, visited, A);
                }
            }
        }
        return count;
    }

    public static void dfsTravelNumOfIsland(int row, int col, boolean[][] visited, ArrayList<ArrayList<Integer>> A){
        visited[row][col] = true;

        int[] rows = {-1, 0, 1, 0, -1, 1, -1, 1};
        int[] cols = {0, -1, 0, 1, -1, 1, 1, -1};

        for (int i = 0; i <= 7; i++) {
            int r = row+ rows[i];
            int c = col+ cols[i];

            if(r >= 0 && r < visited.length && c >= 0 && c < visited[0].length && A.get(r).get(c) == 1 && !visited[r][c])
                dfsTravelNumOfIsland(r, c, visited, A);
        }
    }


    public static int firstDepthFirstSearch(ArrayList<Integer> A, final int B, final int C) {
        List<ArrayList<Integer>> adjList = IntStream.range(0, A.size()+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0,0)))
                .collect(Collectors.toList());

        AtomicInteger index = new AtomicInteger();
        A.stream().forEach(elem -> {
            int currIndex = index.getAndIncrement();
            adjList.get(elem).add(currIndex+1);
        });

        return dfsTravel(C, B, new boolean[A.size()+1], adjList);

    }

    public static int dfsTravel(int node, int dest, boolean[] visited, List<ArrayList<Integer>> adjList){
        visited[node] = true;
        if(node == dest)
            return 1;

        for(Integer i: adjList.get(node)){
            if(!visited[i]){
                int ans = dfsTravel(i, dest, visited, adjList);
                if(ans == 1)
                    return 1;
            }
        }
        return 0;
    }

    public static int pathFrom1ToAInDirectedGraph(int A, ArrayList<ArrayList<Integer>> B) {

        List<ArrayList<Integer>> adjLists = IntStream.range(0, A+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0,0)))
                .collect(Collectors.toList());
        B.stream().forEach(list -> adjLists.get(list.get(0)).add(list.get(1)));

        return pathFrom1ToAInDirectedGraphDfs(A, 1, new boolean[A+1], adjLists);
    }

    static int pathFrom1ToAInDirectedGraphDfs(int A, int node, boolean[] visited, List<ArrayList<Integer>> adjList) {
        visited[node] = true;
        if(node == A){
            return 1;
        }

        for (Integer i: adjList.get(node)){
            if(!visited[node]) {
                int ans = pathFrom1ToAInDirectedGraphDfs(A, i, visited, adjList);
                if (ans == 1)
                    return 1;
            }
        }
        return 0;
    }

}

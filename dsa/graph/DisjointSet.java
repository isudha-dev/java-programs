package dsa.graph;

public class DisjointSet {

    public static void main(String[] args) {
        int n = 9;
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 1-2-5-6-7 3-8-9 4
        union(1,2,parent);
        union(2,5,parent);
        union(5,6,parent);
        union(6,7,parent);
        union(3,8,parent);
        union(8,9,parent);

        System.out.println(isConnected(2, 7,  parent));
        System.out.println(isConnected(3, 9,  parent));
        System.out.println(isConnected(4, 3, parent));
    }

    public static int find(int x, int[] parent){
        while (x != parent[x])
            x = parent[x];

        return x;
    }

    public static void union(int x, int y, int[] parent) {
        int p1 = find(x, parent);
        int p2 = find(y, parent);
        if(p1 != p2)
            parent[p1] = p2;
    }

    public static boolean isConnected(int x, int y, int[] parent){
        if(parent[x] == parent[y])
            return true;

        return false;
    }

}

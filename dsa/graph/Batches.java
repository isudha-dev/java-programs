package dsa.graph;

public class Batches {

    public static void main(String[] args) {
        Batches btc = new Batches();
        int[] B = { 1, 6, 7, 2, 9, 4, 5 };
        int[][] C = { { 1, 2 }, { 2, 3 }, { 5, 6 }, { 5, 7 } };
        btc.solve(7, B, C, 12);
    }

    public int solve(int A, int[] B, int[][] C, int D) {

        int arr[] = new int[A + 1];
        for (int i = 1; i <= A; i++)
            arr[i] = i;

        // creating batches
        for (int i = 0; i < C.length; i++) {
            int u = C[i][0];
            int v = C[i][1];
            int parU = find(u, arr);
            int parV = find(v, arr);
            if (parU != parV) {
                arr = union(u, v, arr);
            }
        }

        return 0;
    }

    public int find(int v, int[] parent) {
        while (parent[v] != v) {
            v = parent[v];
        }
        return v;
    }

    public int[] union(int x, int y, int[] parent) {
        int p1 = find(x, parent);
        int p2 = find(y, parent);
        parent[p1] = p2;

        return parent;
    }

}

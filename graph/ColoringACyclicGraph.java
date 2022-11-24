package graph;

public class ColoringACyclicGraph {
    public int solve(int A) {
        if ((A & 1) == 1)
            return 3;
        else
            return 2;
    }
}

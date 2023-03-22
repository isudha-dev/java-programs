package primer;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image = { { 0, 0, 0 }, { 0, 1, 1 } };
        int sr = 1, sc = 1, newColor = 1;

        floodFill(image, sr, sc, newColor);
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor)
            dfschange(image, sr, sc, newColor, color);
        return image;
    }

    static void dfschange(int[][] image, int sr, int sc, int newColor, int orignal) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != orignal)
            return;
        image[sr][sc] = newColor;
        dfschange(image, sr + 1, sc, newColor, orignal);
        dfschange(image, sr - 1, sc, newColor, orignal);
        dfschange(image, sr, sc + 1, newColor, orignal);
        dfschange(image, sr, sc - 1, newColor, orignal);
    }

    static void checkIfPixedVisited(int l, int r) {

    }
}

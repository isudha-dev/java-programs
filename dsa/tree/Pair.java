package dsa.tree;

public class Pair<T, T1> {
    T root;
    T1 index;

    public Pair(final T root, final T1 index) {
        this.root = root;
        this.index = index;
    }
    public T1 getValue() {
        return index;
    }
    public T getKey() {

        return root;
    }
}

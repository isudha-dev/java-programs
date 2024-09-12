package concepts.Generics;

import java.util.List;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(){

    }

    public Pair(final A first, final B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }
    public void setFirst(final A first) {
        this.first = first;
    }
    public B getSecond() {
        return second;
    }
    public void setSecond(final B second) {
        this.second = second;
    }

    public void printFirsts(List<A> list){
        // only we see methods of Object
        for(A a: list){
            System.out.println(a);
        }
    }

    public void printFirstsWithExtends(List<? extends A> list){
        // only we see methods of Object
        for(A a: list){
            System.out.println(a);
        }
    }

    static <A> List<A> emptyList(){
        return null;
    }
}

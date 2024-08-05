package javas.Generics;

public class OddPredicate implements UnaryPredicate<Integer>{

    @Override
    public boolean test(Integer obj) {
        return (obj&1) == 1 ? true: false ;
    }
}

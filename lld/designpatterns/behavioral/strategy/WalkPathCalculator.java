package lld.designpatterns.behavioral.strategy;

public class WalkPathCalculator implements PathCalculaterStrategy {
    private static WalkPathCalculator instance;

    public static WalkPathCalculator getInstance(){
        if (instance == null) {
            synchronized (WalkPathCalculator.class) {
                if (instance == null) {
                    instance = new WalkPathCalculator();
                }
            }
        }
        return instance;
    }

    @Override public void findPath(final String src, final String dest) {
        System.out.println("Path from source to dest using Walk");

    }

}

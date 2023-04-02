package lld.designpatterns.strategy;

public class CarPathCalculator implements PathCalculaterStrategy {

    private static CarPathCalculator instance;

    public static CarPathCalculator getInstance(){
        if (instance == null) {
            synchronized (CarPathCalculator.class) {
                if (instance == null) {
                    instance = new CarPathCalculator();
                }
            }
        }
        return instance;
    }

    @Override public void findPath(final String src, final String dest) {
        System.out.println("Path from source to dest using Car");

    }
}

package lld.designpatterns.strategy;

public class BikePathCalculator implements PathCalculaterStrategy {
    private static BikePathCalculator instance;

    public static BikePathCalculator getInstance(){
        if (instance == null) {
            synchronized (BikePathCalculator.class) {
                if (instance == null) {
                    instance = new BikePathCalculator();
                }
            }
        }
        return instance;
    }

    @Override public void findPath(final String src, final String dest) {
        System.out.println("Path from source to dest using Bike");

    }

}

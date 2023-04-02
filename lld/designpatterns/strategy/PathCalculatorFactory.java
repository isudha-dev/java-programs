package lld.designpatterns.strategy;

public class PathCalculatorFactory {

    public static PathCalculaterStrategy getPathCalculator(String mode){
        if(mode.equals("Car")){
            return CarPathCalculator.getInstance();
        } else if (mode.equals("Bike")) {
            return BikePathCalculator.getInstance();
        } else
            return WalkPathCalculator.getInstance();
    }

}

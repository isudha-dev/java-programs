package lld.designpatterns.behavioral.strategy;

public class Maps {
    public void findPath(String src, String desc, String mode){
        PathCalculaterStrategy pcs = PathCalculatorFactory.getPathCalculator(mode);
        pcs.findPath(src,desc );
    }

}

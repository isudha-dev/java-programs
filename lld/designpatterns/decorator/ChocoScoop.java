package lld.designpatterns.decorator;

public class ChocoScoop implements IceCream {

    private IceCream iceCreme;

    public ChocoScoop(IceCream iceCreme){
        this.iceCreme = iceCreme;
    }

    @Override public int getCost() {
        return iceCreme.getCost()+30;
    }
    @Override public String getDesc() {
        return iceCreme.getDesc()+" ChocoScoop";
    }
}

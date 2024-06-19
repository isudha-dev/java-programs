package lld.designpatterns.structural.decorator.pizza;

public class ChocoChip implements IceCream {
    private IceCream iceCreme;

    public ChocoChip(IceCream iceCreme){
        this.iceCreme = iceCreme;
    }

    @Override public int getCost() {
        return iceCreme.getCost()+20;
    }
    @Override public String getDesc() {
        return iceCreme.getDesc()+" ChocoChip";
    }
}

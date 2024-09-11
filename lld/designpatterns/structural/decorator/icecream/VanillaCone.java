package lld.designpatterns.structural.decorator.icecream;

public class VanillaCone implements IceCream{
    private IceCream iceCream;

    public VanillaCone(){

    }

    public VanillaCone(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override public int getCost() {
        return iceCream.getCost() + 10;
    }
    @Override public String getDesc() {
        return iceCream.getDesc()+" VanillaCone";
    }
}

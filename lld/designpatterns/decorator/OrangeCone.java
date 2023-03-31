package lld.designpatterns.decorator;

public class OrangeCone implements IceCream {

    private IceCream iceCream;

    public OrangeCone(){

    }

    public OrangeCone(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override public int getCost() {
        if(iceCream == null){
            return 10;
        }
        return iceCream.getCost() + 10;
    }
    @Override public String getDesc() {
        if (iceCream == null){
            return "OrangeCone";
        }
        return iceCream.getDesc()+" OrangeCone";
    }
}

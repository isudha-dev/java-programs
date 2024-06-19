package lld.designpatterns.structural.decorator.pizza;

public class Client {

    public static void main(String[] args) {
        IceCream ic = new ChocoScoop(
                        new VanillaCone(
                            new ChocoChip(
                                new OrangeCone())));

        System.out.println("Ice cream cost: "+ic.getCost());
        System.out.println("Ice cream desc: "+ic.getDesc());
    }

}

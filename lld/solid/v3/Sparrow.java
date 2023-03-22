package lld.solid.v3;

import lld.solid.v3.Birds;

public class Sparrow extends Birds implements FlyBehavior {

    FlyBehavior sparrow;

    public Sparrow(){
        sparrow = new SparrowPeacockFlyBehavior();
        System.out.println("Sparrow -> Sparrow()");
    }

    @Override public void makeFly() {
        sparrow.makeFly();
        System.out.println("Sparrow -> makeFly()");
    }

}

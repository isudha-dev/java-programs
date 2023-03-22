package lld.solid.v3;

public class Peacock extends Birds implements FlyBehavior {

    FlyBehavior peacock;

    public Peacock(){
        peacock = new SparrowPeacockFlyBehavior();
        System.out.println("Peacock -> Peacock()");
    }

    @Override public void makeFly() {
        peacock.makeFly();
        System.out.println("Peacock -> makeFly()");
    }
}

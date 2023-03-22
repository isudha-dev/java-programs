package lld.solid.v3;

public class Pigeon extends Birds implements FlyBehavior {

    FlyBehavior pigeon;

    public Pigeon(){
        pigeon = new CrowPigeonFlyBehavior();
        System.out.println("Pigeon -> Pigeon()");
    }

    @Override public void makeFly() {
        pigeon.makeFly();
        System.out.println("Pigeon -> makeFly()");
    }
}

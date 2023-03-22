package lld.solid.v3;

public class Crow extends Birds implements FlyBehavior {

    FlyBehavior crow;

    public Crow() {
        crow = new CrowPigeonFlyBehavior();
        System.out.println("Crow -> Crow()");
    }

    public void crowMethod() {
        // crow specific method
        System.out.println("Crow ->crowMethod()");
    }

    @Override
    public void makeFly() {
        crow.makeFly();
        System.out.println("Crow -> makeFly()");
    }

}

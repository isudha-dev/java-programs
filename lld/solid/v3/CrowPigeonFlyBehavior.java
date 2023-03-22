package lld.solid.v3;

public class CrowPigeonFlyBehavior implements FlyBehavior{

  public CrowPigeonFlyBehavior(){
    System.out.println("CrowPigeonFlyBehavior -> CrowPigeonFlyBehavior()");
  }
  @Override public void makeFly() {
    System.out.println("CrowPigeonFlyBehavior -> makeFly()");
  }
}

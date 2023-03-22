package lld.solid.v3;

public class SparrowPeacockFlyBehavior implements FlyBehavior{

  public SparrowPeacockFlyBehavior(){
    System.out.println("SparrowPeacockFlyBehavior -> SparrowPeacockFlyBehavior()");
  }

  @Override
  public void makeFly(){
    System.out.println("SparrowPeacockFlyBehavior -> makeFly()");
  }

}

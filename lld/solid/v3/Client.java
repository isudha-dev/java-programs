package lld.solid.v3;

public class Client {

  public static void main(String[] args) {
    System.out.println("----Crow calls----");
    Crow c = new Crow();
    c.crowMethod();
    c.makeFly();

    System.out.println("----Pigeon calls----");
    Pigeon pg = new Pigeon();
    pg.makeFly();

    System.out.println("----Sparrow calls----");
    Sparrow s = new Sparrow();
    s.makeFly();

    System.out.println("----Peacock calls----");
    Peacock pc = new Peacock();
    pc.makeFly();

    System.out.println("----CrowPigeon----");
    CrowPigeonFlyBehavior cpfb = new CrowPigeonFlyBehavior();
    cpfb.makeFly();

    System.out.println("----SparrowPeacock----");
    SparrowPeacockFlyBehavior spfb = new SparrowPeacockFlyBehavior();
    spfb.makeFly();

  }

}

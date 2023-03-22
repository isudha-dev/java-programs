package lld.designpatterns.prototype;

public class SmartStudent extends Student{

  private int iq;

  public SmartStudent(){

  }

  public SmartStudent(SmartStudent s) {
    super(s);
    this.iq = s.iq;
  }

  public SmartStudent clone(SmartStudent s){
    return new SmartStudent(s);
  }

  public int getIq() {
    return iq;
  }

  public void setIq(final int iq) {
    this.iq = iq;
  }
}

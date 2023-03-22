package lld.designpatterns.prototyperegistry;

public class SmartStudent extends Student{

  private int iq;

  public SmartStudent(){

  }

  public SmartStudent(SmartStudent s) {
    super(s);
    this.iq = s.iq;
  }

  public
  SmartStudent clone(){
    return new SmartStudent(this);
  }

  public int getIq() {
    return iq;
  }

  public void setIq(final int iq) {
    this.iq = iq;
  }

  @Override public String toString() {
    return super.toString() + " SmartStudent{" +
        "iq=" + iq +
        '}';
  }
}

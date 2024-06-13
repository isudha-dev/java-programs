package lld.designpatterns.prototyperegistry.student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmartStudent extends Student{

  private int iq;

  public SmartStudent(){

  }

  public SmartStudent(SmartStudent s) {
    super(s);
    this.iq = s.iq;
  }

  public SmartStudent clone(){
    return new SmartStudent(this);
  }

  @Override public String toString() {
    return super.toString() + " SmartStudent{" +
        "iq=" + iq +
        '}';
  }
}

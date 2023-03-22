package lld.designpatterns.prototyperegistry;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

  Map<String, Student> registry = new HashMap<>();

  public void save(Student s){
    registry.put(s.getBatchName(), s);
  }

  public Student get(String batchName) {
    return registry.get(batchName);
  }

}

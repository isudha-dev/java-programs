package lld.designpatterns.creational.prototyperegistry.train;

import java.util.HashMap;
import java.util.Map;

public class TrainRegistry {
  Map<String, Train> map = new HashMap<>();

  public Train get(String s){
    return  map.get(s);
  }

  public void save(String s, Train t){
    map.put(s,t);
  }



}

package lld.designpatterns.creational.prototyperegistry.train;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Train implements Prototype<Train> {

  private int fare;
  private String trainType;
  private String engineType;
  private int noOfSeats;
  private String time;
  private List<String> stations;

  public Train(){

  }

  private Train(Train t){
    this.fare = t.fare;
    this.trainType = t.trainType;
    this.engineType = t.engineType;
    this.noOfSeats = t.noOfSeats;

  }

  @Override public Train clone() {
    return new Train(this);
  }

  @Override public String toString() {
    return "Train{" +
        "fare=" + fare +
        ", trainType='" + trainType + '\'' +
        ", engineType='" + engineType + '\'' +
        ", noOfSeats=" + noOfSeats +
        ", time=" + time +
        ", stations=" + stations +
        '}';
  }
}

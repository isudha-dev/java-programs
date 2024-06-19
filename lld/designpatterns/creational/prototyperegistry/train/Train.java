package lld.designpatterns.creational.prototyperegistry.train;

import java.util.List;

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

  public void setFare(final int fare) {
    this.fare = fare;
  }
  public void setTrainType(final String trainType) {
    this.trainType = trainType;
  }
  public void setEngineType(final String engineType) {
    this.engineType = engineType;
  }
  public void setNoOfSeats(final int noOfSeats) {
    this.noOfSeats = noOfSeats;
  }
  public void setTime(final String time) {
    this.time = time;
  }
  public void setStations(final List<String> stations) {
    this.stations = stations;
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

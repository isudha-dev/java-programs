package lld.designpatterns.prototyperegistry.train;

import java.util.List;
import java.time.*;

public class Client {

  public static void main(String[] args) {

    TrainRegistry registry = new TrainRegistry();
    Train train = new Train();
    train.setFare(100);
    train.setTrainType("AC");
    train.setEngineType("Electric");
    train.setNoOfSeats(1500);

    registry.save("Train1", train);

    Train centralTrain = registry.get("Train1").clone();
    centralTrain.setTime("1:40 AM");
    centralTrain.setStations(List.of("Thane", "Dadar","CSTM"));

    System.out.println(centralTrain);
  }

}

package lld.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon {

    private static Amazon instance;
    private List<OrderPlaceSubscriber> orderPlaceSubscribers;

    private Amazon(){
        orderPlaceSubscribers = new ArrayList<>();
    }

    public static Amazon getInstance(){
        if(instance == null){
            instance = new Amazon();
        }
        return instance;
    }

    public void registerSubscriber(OrderPlaceSubscriber ops){
        orderPlaceSubscribers.add(ops);
    }

    public void deregisterSubscriber(OrderPlaceSubscriber ops){
        orderPlaceSubscribers.remove(ops);
    }

    public void orderPlaced(){
        for(OrderPlaceSubscriber ops : orderPlaceSubscribers){
            ops.orderPlacedEvent();
        }
    }

}

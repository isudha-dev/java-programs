package lld.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon {

    private static Amazon instance;
    private List<OrderPlaceSubscriber> orderPlaceSubscribers;
    private List<OrderCancelSubscriber> orderCancelSubscribers;

    private Amazon(){
        orderPlaceSubscribers = new ArrayList<>();
        orderCancelSubscribers = new ArrayList<>();
    }

    public static Amazon getInstance(){
        if(instance == null){
            instance = new Amazon();
        }
        return instance;
    }

    public void registerOrderPlaceSubscriber(OrderPlaceSubscriber ops){
        orderPlaceSubscribers.add(ops);
    }

    public void deregisterOrderPlaceSubscriber(OrderPlaceSubscriber ops){
        orderPlaceSubscribers.remove(ops);
    }

    public void registerOrderCancelSubscriber(OrderCancelSubscriber ocs){
        orderCancelSubscribers.add(ocs);
    }

    public void deregisterOrderCancelSubscriber(OrderCancelSubscriber ocs){
        orderCancelSubscribers.remove(ocs);
    }

    public void orderPlaced(){
        for(OrderPlaceSubscriber ops : orderPlaceSubscribers){
            ops.orderPlacedEvent();
        }
    }

    public void orderCancelled(){
        for(OrderCancelSubscriber ocs : orderCancelSubscribers){
            ocs.orderCancelEvent();
        }
    }

}

package lld.designpatterns.behavioral.observer;

public class CustomerNotifier implements OrderPlaceSubscriber, OrderCancelSubscriber{

    public CustomerNotifier(){
        Amazon a = Amazon.getInstance();
        a.registerOrderPlaceSubscriber(this);
        a.registerOrderCancelSubscriber(this);
    }

    @Override public ReturnData orderPlacedEvent() {
        ReturnData rd = new ReturnData("Customer is notified for placing order.");
        return rd;
    }

    @Override public ReturnData orderCancelEvent() {
        ReturnData rd = new ReturnData("Customer is notified for cancelling order.");
        return rd;
    }
}

package lld.designpatterns.observer;

public class CustomerNotifier implements OrderPlaceSubscriber{

    public CustomerNotifier(){
        Amazon.getInstance().registerSubscriber(this);
    }

    @Override public ReturnData orderPlacedEvent() {
        ReturnData rd = new ReturnData("Customer is notified.");
        return rd;
    }
}

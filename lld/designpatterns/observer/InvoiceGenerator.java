package lld.designpatterns.observer;

public class InvoiceGenerator implements OrderPlaceSubscriber, OrderCancelSubscriber{

    public InvoiceGenerator(){
        Amazon a = Amazon.getInstance();
        a.registerOrderPlaceSubscriber(this);
        a.registerOrderCancelSubscriber(this);
    }

    @Override public ReturnData orderPlacedEvent() {
        ReturnData rd = new ReturnData("Invoice is generated for placing order.");
        return rd;
    }
    @Override public ReturnData orderCancelEvent() {
        ReturnData rd = new ReturnData("Invoice is generated for cancelling order");
        return rd;
    }
}

package lld.designpatterns.observer;

public class InvoiceGenerator implements OrderPlaceSubscriber{

    public InvoiceGenerator(){
        Amazon.getInstance().registerSubscriber(this);
    }

    @Override public ReturnData orderPlacedEvent() {
        ReturnData rd = new ReturnData("Invoice is generated.");
        return rd;
    }
}

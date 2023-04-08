package lld.designpatterns.observer;

public class WarehouseMgmtNotifier implements OrderPlaceSubscriber, OrderCancelSubscriber{

    public WarehouseMgmtNotifier(){
        Amazon a = Amazon.getInstance();
        a.registerOrderPlaceSubscriber(this);
        a.registerOrderCancelSubscriber(this);
    }

    @Override public ReturnData orderPlacedEvent() {
        ReturnData rd = new ReturnData("Warehouse management is notified for placing order.");
        return rd;
    }
    @Override public ReturnData orderCancelEvent() {
        ReturnData rd = new ReturnData("Warehouse management is notified for cancelling order.");
        return rd;
    }
}

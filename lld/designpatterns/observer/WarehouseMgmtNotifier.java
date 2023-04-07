package lld.designpatterns.observer;

public class WarehouseMgmtNotifier implements OrderPlaceSubscriber{

    public WarehouseMgmtNotifier(){
        Amazon.getInstance().registerSubscriber(this);
    }

    @Override public ReturnData orderPlacedEvent() {
        ReturnData rd = new ReturnData("Warehouse management is notified.");
        return rd;
    }
}

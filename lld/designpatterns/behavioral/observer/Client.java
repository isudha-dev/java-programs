package lld.designpatterns.behavioral.observer;

public class Client {

    public static void main(String[] args) {
        Amazon a = Amazon.getInstance();
        CustomerNotifier cn = new CustomerNotifier();
        WarehouseMgmtNotifier wmn = new WarehouseMgmtNotifier();
        InvoiceGenerator ig = new InvoiceGenerator();
        a.orderPlaced();
        System.out.println();
        a.deregisterOrderPlaceSubscriber(ig);
        a.orderPlaced();
        System.out.println();
        a.orderCancelled();
        System.out.println();
        a.deregisterOrderCancelSubscriber(wmn);
        a.orderCancelled();
    }

}

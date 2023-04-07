package lld.designpatterns.observer;

public class Client {

    public static void main(String[] args) {
        Amazon a = Amazon.getInstance();
        CustomerNotifier cn = new CustomerNotifier();
        WarehouseMgmtNotifier wmn = new WarehouseMgmtNotifier();
        InvoiceGenerator ig = new InvoiceGenerator();
        a.orderPlaced();
        System.out.println();
        a.deregisterSubscriber(ig);
        a.orderPlaced();
    }

}

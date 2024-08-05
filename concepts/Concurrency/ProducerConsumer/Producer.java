package javas.Concurrency.ProducerConsumer;

public class Producer implements Runnable{

    Store store;

    public Producer(Store store){
        this.store = store;
    }

    @Override public void run() {
        while (true){
            synchronized (store) {
                if (store.getItems().size() < store.getMaxSize()) {
                    store.addItem(new Object());
                }
            }
        }

    }
}

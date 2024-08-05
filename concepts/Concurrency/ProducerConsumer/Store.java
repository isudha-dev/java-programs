package javas.Concurrency.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize;
    List<Object> items;
    public int getMaxSize() {
        return maxSize;
    }
    public void setMaxSize(final int maxSize) {
        this.maxSize = maxSize;
    }
    public List<Object> getItems() {
        return items;
    }
    public void setItems(final List<Object> items) {
        this.items = items;
    }
    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public void addItem(Object o){
        items.add(o);
        System.out.println("Item produced: "+ items.size());
    }

    public void removeItem(){
        items.remove(items.size()-1);
        System.out.println("Item consumed: "+ items.size());
    }
}

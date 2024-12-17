package Semaphores.producerConsumerSemaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    private int maxSize;
    private ConcurrentLinkedQueue<Object> items;

    Store(int maxSize) {
        this.maxSize = maxSize;
        // Array list is not made for concurrent access : Not a thread safe
        //hence we use ConcurrentLinkedQueue
        // items = new ArrayList<>(maxSize);
        items = new ConcurrentLinkedQueue<>();
    }

    public void addItem(Object item){
        //here at a time 5 thread trying to add an item, hence we need to use concurrent collection
        items.add(item);
        System.out.println("Producer is producing the items : " + items.size());
    }

    public void removeItem(){
        items.remove();
        System.out.println("Consumer has consumed the item : " + items.size());
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public ConcurrentLinkedQueue<Object> getItems() {
        return items;
    }

    public void setItems(ConcurrentLinkedQueue<Object> items) {
        this.items = items;
    }
}

package Semaphores.producerConsumerSync;

public class Producer implements Runnable{
    private Store store;

    Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        //a producer should always keep on producing
        while(true){
            //using critical section inside sync block
            //but this is not the best way to solve this problem
            //because if we have more than on empty shelf (or available item) available
            // sync block allow only one thread to produce an item. This may cause performance degrade.
            // So to increase performance we can produce more than one item at a time if we have empty shelf
            // for that we can use semaphores
            synchronized (store){
                if(store.getItems().size() < store.getMaxSize()){
                    store.addItem(new Object());
                }
            }
        }
    }
}

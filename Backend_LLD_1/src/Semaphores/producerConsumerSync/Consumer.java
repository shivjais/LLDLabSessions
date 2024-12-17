package Semaphores.producerConsumerSync;

public class Consumer implements Runnable{
    private Store store;

    Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            //using critical section inside sync block
            synchronized (store){
                if(store.getItems().size() > 0){
                    store.removeItem();
                }
            }
        }
    }
}

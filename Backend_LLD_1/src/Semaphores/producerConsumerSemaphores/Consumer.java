package Semaphores.producerConsumerSemaphores;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore,consumerSemaphore;

    Consumer(Store store,Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){
            //using critical section inside sync block
            try {
                //here we don't need to check item is available or not to consume
                //take lock & check item is available
                consumerSemaphore.acquire();
                //if item is available then remove it
                store.removeItem();
                //release lock & give signal to producer to produce the item
                producerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

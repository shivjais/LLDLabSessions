package Semaphores.producerConsumerSemaphores;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore,consumerSemaphore;

    Producer(Store store,Semaphore producerSemaphore,Semaphore consumerSemaphore){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        //a producer should always keep on producing
        while(true){
            try {
                //here we don't need to check shelf is available or not to produce
                //take lock & check shelf is available
                producerSemaphore.acquire();
                //produce an item
                store.addItem(new Object());
                //release lock & give signal to consumer to consume the item
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}

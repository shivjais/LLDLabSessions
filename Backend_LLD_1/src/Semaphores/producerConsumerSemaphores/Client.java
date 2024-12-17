package Semaphores.producerConsumerSemaphores;

import java.util.concurrent.Semaphore;

//Here we can see the Producer & consumer problem can be solved using Semaphore
//When we want more than one thread (but in limited number) to execute critical section
//then we can use Semaphore
//Semaphore = mutual exclusion + counter
public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);

        //intially we have 5 consumer token & 0 consumer token
        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        for(int i = 0; i < 8; i++){
            Producer producer = new Producer(store,producerSemaphore,consumerSemaphore);
            new Thread(producer).start();
        }

        for(int i = 0; i <100; i++){
            Consumer consumer = new Consumer(store,producerSemaphore,consumerSemaphore);
            new Thread(consumer).start();
        }
    }
}

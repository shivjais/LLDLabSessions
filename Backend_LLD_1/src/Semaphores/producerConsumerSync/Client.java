package Semaphores.producerConsumerSync;

//Here we can see the Producer & consumer problem can be solved using sync block
//but this is not best way to solve this problem
//because if we have more than on empty self available sync block allow only one thread to produce an item
public class Client {
    public static void main(String[] args) {
        Store store = new Store(3);

        //Creating 8 Producer thread which continuously producing items
        for(int i = 0; i < 8; i++){
            Producer producer = new Producer(store);
            new Thread(producer).start();
        }
        //Creating 100 Consumer thread which continuously Consuming items
        for(int i = 0; i <100; i++){
            Consumer consumer = new Consumer(store);
            new Thread(consumer).start();
        }
    }
}

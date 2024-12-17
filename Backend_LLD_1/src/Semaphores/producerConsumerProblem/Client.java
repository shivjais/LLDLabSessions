package Semaphores.producerConsumerProblem;

//Here we can see the synchonisation problem
//When have limited number of consumer & more number of consumer
//we will get index out of bound error
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

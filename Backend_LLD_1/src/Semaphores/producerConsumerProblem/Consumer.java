package Semaphores.producerConsumerProblem;

public class Consumer implements Runnable{
    private Store store;

    Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            //if currSize =  2, Number of consumer on line 14 is more than 2
            //then below condition will true for more thread & all try to remove item
            //which can cause index out of bound error
            if(store.getItems().size() > 0){
                store.removeItem();
            }
        }
    }
}

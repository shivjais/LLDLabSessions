package Semaphores.producerConsumerProblem;

public class Producer implements Runnable{
    private Store store;

    Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
//        a producer should always keep on producing

        while(true){
            //if currSize =  2, Number of consumer on below line is more than 2
            //then below condition will true for more thread & all try to add item
            if(store.getItems().size() < store.getMaxSize()){
                store.addItem(new Object());
            }
        }
    }
}

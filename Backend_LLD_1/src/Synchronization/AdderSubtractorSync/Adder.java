package Synchronization.AdderSubtractorSync;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value val;


    public Adder(Value val){
        this.val = val;
    }
    @Override
    public Void call() throws Exception {
        for(int i=1;i<=10000;i++){
            //synchronized will take implicit lock on the object
            // we must need to pass shared object in sync block
            synchronized (val){
                val.setVal(val.getVal()+i);
            }

            //release lock after critical section

        }
        return null;
    }
}

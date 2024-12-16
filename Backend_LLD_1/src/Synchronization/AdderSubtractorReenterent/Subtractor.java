package Synchronization.AdderSubtractorReenterent;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value val;
    private Lock lock;

    public Subtractor(Value val,Lock lock){
        this.val = val;
        this.lock = lock;
    }
    @Override
    public Void call() throws Exception {
        for(int i=1;i<=10000;i++){
            //accruing lock before critical section
            lock.lock();
            val.setVal(val.getVal()-i);
            //release lock after critical section
            lock.unlock();
        }
        return null;
    }
}

package Synchronization.AdderSubtractorAtomic;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Adder implements Callable<Void> {
    private Value val;


    public Adder(Value val){
        this.val = val;
    }
    @Override
    public Void call() throws Exception {
        for(int i=1;i<=10000;i++){
           val.getVal().addAndGet(i);
        }
        return null;
    }
}

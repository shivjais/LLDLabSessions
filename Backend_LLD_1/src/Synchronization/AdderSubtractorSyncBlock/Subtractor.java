package Synchronization.AdderSubtractorSyncBlock;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value val;

    public Subtractor(Value val){
        this.val = val;

    }
    @Override
    public Void call() throws Exception {
        for(int i=1;i<=10000;i++){
            //added critical section code in incrementedBy method
            val.incrementedBy(-i);
        }
        return null;
    }
}

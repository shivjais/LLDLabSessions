package Synchronization.AdderSubtractorSync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

//here we have synchronisation issue
//because we are using same shared resource in two thread
//we will fix this using synchronized block/method
public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();
        value.setVal(0);
        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Void> addFuture = executorService.submit(adder);
        Future<Void> subFuture = executorService.submit(subtractor);
        addFuture.get();
        subFuture.get();
        //generate unexpected result in every run
        System.out.println(value.getVal());
        executorService.shutdown();
    }
}

package Synchronization.AdderSubtractorReenterent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

//here we have synchronisation issue
//because we are using same shared resource in two thread
//we will fix this using ReentrantLock
public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();
        value.setVal(0);
        //Adding ReentrantLock to apply lock in critical section
        ReentrantLock lock = new ReentrantLock();
        Adder adder = new Adder(value,lock);
        Subtractor subtractor = new Subtractor(value,lock);
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
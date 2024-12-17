package Synchronization.AdderSubtractorAtomic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//here we have synchronisation issue
//because we are using same shared resource (value) in two thread
//we will fix this using Atomic variable
public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();
        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Void> addFuture = executorService.submit(adder);
        Future<Void> subFuture = executorService.submit(subtractor);
        addFuture.get();
        subFuture.get();
        System.out.println(value.getVal());
        executorService.shutdown();
    }
}

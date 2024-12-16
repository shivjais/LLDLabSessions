package ExecutorService.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//This will print number from 1 to n
public class Client {
    public static void main(String[] args) {

        //newFixedThreadPool created pool of 5 threads which is used to execute task
        //ExecutorService executorService = Executors.newFixedThreadPool(5);

        //newCachedThreadPool creates a thread pool.
        // From thread pool new thread will only create iff there is no idle thread or used the idle thread
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1;i<=100;i++){
            NumberPrinter printer = new NumberPrinter(i);
            executorService.execute(printer);
        }
    }
}

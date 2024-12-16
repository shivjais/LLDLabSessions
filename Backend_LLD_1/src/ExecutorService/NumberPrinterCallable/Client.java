package ExecutorService.NumberPrinterCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

         ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1;i<=100;i++){
            NumberPrinter printer = new NumberPrinter(i);
            Future<Integer> numFuture = executorService.submit(printer);
            System.out.println(numFuture.get());

        }
    }
}

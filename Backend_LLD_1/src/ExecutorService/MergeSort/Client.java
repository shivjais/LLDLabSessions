package ExecutorService.MergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(22,4,55,1,7,4,0,6);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(list,executorService);
        Future<List<Integer>> sortedList = executorService.submit(sorter);
        System.out.println(sortedList.get());
    }
}

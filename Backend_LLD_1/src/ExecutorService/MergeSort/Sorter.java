package ExecutorService.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> sortList;
    private ExecutorService executorService;

    public Sorter(List<Integer> list, ExecutorService executorService){
        this.sortList = list;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(sortList.size() <= 1){
            return sortList;
        }
        int mid = sortList.size()/2;

        //Sort left & right array in separate thread
        Sorter leftSorter = new Sorter(sortList.subList(0,mid),executorService);
        Sorter rightSorter = new Sorter(sortList.subList(mid,sortList.size()),executorService);
        Future<List<Integer>> leftFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture = executorService.submit(rightSorter);

        //here one thread (left or right) will wait until another thread will complete its task
        List<Integer> leftSortedList = leftFuture.get();
        List<Integer> rightSortedList = rightFuture.get();
        return merge(leftSortedList, rightSortedList);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right){
        int l = 0, r = 0;
        List<Integer> sortedList = new ArrayList<>();
        while(l < left.size() && r < right.size()){
            if(left.get(l) < right.get(r)){
                sortedList.add(left.get(l));
                l++;
            }else{
                sortedList.add(right.get(r));
                r++;
            }
        }

        while(l < left.size()){
            sortedList.add(left.get(l));
            l++;
        }
        while(r < right.size()){
            sortedList.add(right.get(r));
            r++;
        }
        return  sortedList;
    }
}

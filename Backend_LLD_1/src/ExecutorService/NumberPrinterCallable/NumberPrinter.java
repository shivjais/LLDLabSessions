package ExecutorService.NumberPrinterCallable;

import java.util.concurrent.Callable;

//This will generate multiple of 5 of given number
public class NumberPrinter implements Callable<Integer> {
    int num;
    public NumberPrinter(int num){
        this.num = num;
    }
    @Override
    public Integer call() {

        return num * 5;
    }
}

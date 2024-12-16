package ExecutorService.NumberPrinter;

public class NumberPrinter implements  Runnable{
    int val ;
    public NumberPrinter(int val){
        this.val = val;
    }
    @Override
    public void run() {
        System.out.println("Number: "+val+" Thread: "+Thread.currentThread().getName());
    }
}

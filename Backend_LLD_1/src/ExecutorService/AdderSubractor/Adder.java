package ExecutorService.AdderSubractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value val;

    public Adder(Value val){
        this.val = val;
    }
    @Override
    public Void call() throws Exception {
        for(int i=1;i<=10000;i++){
            val.setVal(val.getVal()+i);
        }
        return null;
    }
}

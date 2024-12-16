package Synchronization.AdderSubtractorSyncBlock;

public class Value {
    private  int val;

    public Value(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    //synchronized keyword with method will take object level local
    //if 2 thread using same object reference to call synchronized method
    //then at a time only one thread get a change to execute it
    public synchronized void incrementedBy(int x){
        val += x;
    }
}

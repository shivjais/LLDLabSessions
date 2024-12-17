package Synchronization.AdderSubtractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {
    private AtomicInteger val = new AtomicInteger(0);

    public AtomicInteger getVal() {
        return val;
    }

}

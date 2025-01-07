package Synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        // Create an AtomicInteger with an initial value
        AtomicInteger atomicInteger = new AtomicInteger(0);

        // Perform atomic increment
        int newValue = atomicInteger.incrementAndGet();
        System.out.println("Incremented Value: " + newValue);

        // Perform atomic decrement
        newValue = atomicInteger.decrementAndGet();
        System.out.println("Decremented Value: " + newValue);

        // Perform atomic add
        int addValue = 5;
        newValue = atomicInteger.addAndGet(addValue);
        System.out.println("After Adding " + addValue + ": " + newValue);

        // Perform compare-and-set operation
        int expectedValue = 5;
        int updateValue = 10;
        boolean success = atomicInteger.compareAndSet(expectedValue, updateValue);
        if (success) {
            System.out.println("Value updated successfully. New Value: " + atomicInteger.get());
        } else {
            System.out.println("Value was not updated. Current Value: " + atomicInteger.get());
        }

    }
}

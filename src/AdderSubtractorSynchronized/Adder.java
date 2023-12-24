package AdderSubtractorSynchronized;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Adder implements Runnable {
    private Count count;
    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            // CS starts

            // synchronized (this) { // this prevents multiple threads to enter this same object
            // synchronized (Adder.class) { // this prevents multiple threads to enter this class, could be useful when
            //      we have a static method/class ('this' wouldn't work then). Worst kind of lock, performance wise
            synchronized (count) {
                int val = count.getValue();
                val += i;
                count.setValue(val);
            }
            // CS ends

            // OR
            // count.incrementCount(i);
        }
    }
}

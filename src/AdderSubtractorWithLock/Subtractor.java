package AdderSubtractorWithLock;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;
    private Lock lock;
    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            // CS starts
            lock.lock();

            int val = count.getValue();
            val -= i;
            count.setValue(val);

            lock.unlock();
            // CS ends
        }
    }
}

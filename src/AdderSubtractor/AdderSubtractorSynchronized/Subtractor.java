package AdderSubtractor.AdderSubtractorSynchronized;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;
    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            // CS starts
            synchronized (count) {
                int val = count.getValue();
                val -= i;
                count.setValue(val);
            }
            // CS ends

            // OR
            // count.decrementCount(i);
        }
    }
}

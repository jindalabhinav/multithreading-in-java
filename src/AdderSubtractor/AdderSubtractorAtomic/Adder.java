package AdderSubtractor.AdderSubtractorAtomic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Adder implements Runnable {
    private Count count;

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            count.getValue().getAndAdd(i);
        }
    }
}

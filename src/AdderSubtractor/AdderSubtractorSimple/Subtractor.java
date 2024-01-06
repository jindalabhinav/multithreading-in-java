package AdderSubtractor.AdderSubtractorSimple;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            int val = count.getValue();
            val -= i;
            count.setValue(val);
        }
    }
}

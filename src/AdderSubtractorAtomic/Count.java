package AdderSubtractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
    private AtomicInteger value = new AtomicInteger();

    public AtomicInteger getValue() {
        return value;
    }
}

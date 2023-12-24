package AdderSubtractorSynchronized;

public class Count {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // these 2 methods can also be used, and we can let go of the synchronized logic from the Adder and Subtractor Class
    public synchronized void incrementCount(int offset) {
        value += offset;
    }

    public synchronized void decrementCount(int offset) {
        value += offset;
    }
}

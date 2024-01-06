package ProducerConsumer.ProducerConsumerSynchronized;

import lombok.AllArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
public class Producer implements Runnable {
    private String name;
    private Queue<UnitOfWork> buffer;
    private Integer maxSize;

    @Override
    public void run() {
        while (true) {
            // base case
            synchronized (buffer) {
                if (buffer.size() < maxSize) {
                    buffer.add(new UnitOfWork());
                    System.out.println(name + " produced food. Current size: " + buffer.size());
                }
            }
        }
        // with this implementation, only 1 producer can produce to the Queue at a time
        // we'll change this with Semaphores
    }
}

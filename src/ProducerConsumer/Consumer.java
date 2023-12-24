package ProducerConsumer;

import lombok.AllArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
public class Consumer implements Runnable {
    private String name;
    private Queue<UnitOfWork> buffer;

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (!buffer.isEmpty()) {
                    buffer.remove();
                    System.out.println(name + " consumed. Existing buffer size: " + buffer.size());
                }
            }
        }
        // with this implementation, only 1 consumer can consume from the Queue at a time
        // we'll change this with Semaphores
    }
}

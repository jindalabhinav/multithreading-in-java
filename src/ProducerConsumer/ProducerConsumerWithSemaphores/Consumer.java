package ProducerConsumer.ProducerConsumerWithSemaphores;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class Consumer implements Runnable {
    private String name;
    private Queue<UnitOfWork> buffer;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            forConsumer.acquire();
            buffer.remove();
            forProducer.release();

            System.out.println(name + " consumed. Existing buffer size: " + buffer.size());
        }
        // with this implementation, multiple threads can enter the CS until the Semaphore value reaches 0.

        // once the consumer is done consuming, it signals the Producer Semaphore and increases its value by 1 so that
        // a producer thread can start producing
    }
}

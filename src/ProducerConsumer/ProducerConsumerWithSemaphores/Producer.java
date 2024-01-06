package ProducerConsumer.ProducerConsumerWithSemaphores;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class Producer implements Runnable {
    private String name;
    private Queue<UnitOfWork> buffer;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            forProducer.acquire();
            buffer.add(new UnitOfWork());
            forConsumer.release();

            System.out.println(name + " produced food. Current size: " + buffer.size());
        }
        // with this implementation, multiple threads can enter the CS until the Semaphore value reaches 0.

        // once the producer is done producing, it signals the Consumer Semaphore and increases its value by 1 so that
        // a consumer thread can start consuming
    }
}

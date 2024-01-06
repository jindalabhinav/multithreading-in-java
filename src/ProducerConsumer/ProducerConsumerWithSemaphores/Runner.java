package ProducerConsumer.ProducerConsumerWithSemaphores;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Runner {
    private static final Set<String> producerNames = Set.of("p1", "p2", "p3");
    private static final Set<String> consumerNames = Set.of("c1", "c2", "c3", "c4");

    public static void main(String[] args) {

        /*  ConcurrentLinkedDeque vs ArrayDeque
            If you require concurrent access to a deque from multiple threads, and you want to avoid locks, ConcurrentLinkedDeque is a good choice.
            If you are working in a single-threaded environment or can ensure external synchronization, ArrayDeque can be a simpler and more memory-efficient choice.
        */
        Queue<UnitOfWork> buffer = new ConcurrentLinkedDeque<>();
        int maxSize = 20; //buffer size
        Semaphore forProducer = new Semaphore(maxSize);
        Semaphore forConsumer = new Semaphore(0);
        Set<Producer> producers = producerNames
                .stream()
                .map(name -> new Producer(name, buffer, forProducer, forConsumer))
                .collect(Collectors.toSet());
        Set<Consumer> consumers = consumerNames
                .stream()
                .map(name -> new Consumer(name, buffer, forProducer, forConsumer))
                .collect(Collectors.toSet());

        producers.forEach(p -> new Thread(p).start());
        consumers.forEach(c -> new Thread(c).start());
    }
}

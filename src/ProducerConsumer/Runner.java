package ProducerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Runner {
    private static final Set<String> producerNames = Set.of("p1", "p2", "p3");
    private static final Set<String> consumerNames = Set.of("c1", "c2", "c3", "c4");

    public static void main(String[] args) {
        Queue<UnitOfWork> buffer = new ArrayDeque<>();
        int maxSize = 20; //buffer size

        Set<Producer> producers = producerNames
                .stream()
                .map(name -> new Producer(name, buffer, maxSize))
                .collect(Collectors.toSet());
        Set<Consumer> consumers = consumerNames
                .stream()
                .map(name -> new Consumer(name, buffer))
                .collect(Collectors.toSet());

        producers.forEach(p -> new Thread(p).start());
        consumers.forEach(c -> new Thread(c).start());
    }
}

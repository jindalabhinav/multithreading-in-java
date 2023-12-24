package AdderSubtractorWithLock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Lock lock = new ReentrantLock();
            var count = new Count();
            var adder = new Adder(count, lock);
            var subtractor = new Subtractor(count, lock);

            var executor = Executors.newCachedThreadPool();
            executor.execute(adder);
            executor.execute(subtractor);

            // Wait for the termination of the executor after both tasks have completed
            executor.awaitTermination(3, TimeUnit.SECONDS);

            // Output the value after each iteration
            System.out.println("Iteration " + i + ": " + count.getValue());

            // Shut down the executor to release resources
            executor.shutdown();
        }
    }
}

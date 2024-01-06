package ThreadImplementations.Runnable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Current thread is " +  Thread.currentThread().getName());

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            Runnable numberPrinter = new PrinterRunnable(i);

            // Managing the threads manually, number of threads can grow without bounds
            // Thread thread = new Thread(numberPrinter);
            // thread.start();

            // Delegating the task of managing threads to the executor
            executor.execute(numberPrinter);
            executor.shutdown(); // Initiates an orderly shutdown
        }
    }
}

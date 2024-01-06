package ThreadImplementations.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Current thread is " +  Thread.currentThread().getName());

        ExecutorService executor = Executors.newSingleThreadExecutor();

        PrinterCallable textPrinterCallable = new PrinterCallable();
        Future<String> output = executor.submit(textPrinterCallable); // like a receipt
        System.out.println("Not blocked on Future");
//        while (!output.isDone()) {
//            System.out.println(output.get()); // This is a blocking call, so no need to call isDone
//        }
        System.out.println(output.get());
    }
}

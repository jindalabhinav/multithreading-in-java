package ThreadImplementations;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Current thread is " +  Thread.currentThread().getName());
//        ThreadImplementations.Printer printer1 = new ThreadImplementations.Printer();
//        printer1.start();
//
//        ThreadImplementations.Printer printer2 = new ThreadImplementations.Printer();
//        printer2.start();

//        Executor executor = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 100_000_000; i++) {
//            Runnable numberPrinter = new ThreadImplementations.NumberPrinterRunnable(i);
////            numberPrinter.start();
////            Thread thread = new Thread(numberPrinter);
////            thread.start();
//            executor.execute(numberPrinter);
//        }

        ExecutorService executor = Executors.newSingleThreadExecutor();

        TextPrinterCallable textPrinterCallable = new TextPrinterCallable();
        Future<String> output = executor.submit(textPrinterCallable); // like a receipt
        System.out.println("Not blocked on Future");
//        while (!output.isDone()) {
//            System.out.println(output.get()); // This is a blocking call, so no need to call isDone
//        }
        System.out.println(output.get());
    }
}
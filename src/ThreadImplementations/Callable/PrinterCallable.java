package ThreadImplementations.Callable;

import java.util.concurrent.Callable;

public class PrinterCallable implements Callable<String> {
    @Override
    public String call() {
        return "Hello, World! From thread: " + Thread.currentThread().getName();
    }
}

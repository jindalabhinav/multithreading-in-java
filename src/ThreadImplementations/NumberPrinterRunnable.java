package ThreadImplementations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//public class ThreadImplementations.NumberPrinterRunnable extends Thread {
public class NumberPrinterRunnable implements Runnable {
    private Integer number;

    @Override
    public void run() {
        System.out.println("Number: " + number + ", printed by thread: " + Thread.currentThread().getName());
    }
}

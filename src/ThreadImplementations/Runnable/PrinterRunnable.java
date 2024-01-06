package ThreadImplementations.Runnable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrinterRunnable implements Runnable {
    private Integer number;

    @Override
    public void run() {
        System.out.println("Number: " + number + ", printed by thread: " + Thread.currentThread().getName());
    }
}

package ThreadImplementations;

public class PrinterThread extends Thread {
    @Override
    public void run() {
        System.out.println("Printed by: " +  Thread.currentThread().getName());
    }

}

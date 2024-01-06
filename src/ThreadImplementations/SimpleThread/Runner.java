package ThreadImplementations.SimpleThread;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Current thread is " +  Thread.currentThread().getName());

        PrinterThread printer1 = new PrinterThread();
        printer1.start();

        PrinterThread printer2 = new PrinterThread();
        printer2.start();
    }
}

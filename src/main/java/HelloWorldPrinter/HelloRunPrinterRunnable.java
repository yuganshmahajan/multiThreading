package HelloWorldPrinter;

public class HelloRunPrinterRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World" + Thread.currentThread());
    }
}

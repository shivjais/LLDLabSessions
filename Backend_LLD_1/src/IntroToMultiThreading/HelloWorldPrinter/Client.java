package IntroToMultiThreading.HelloWorldPrinter;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrinter printer = new HelloWorldPrinter();
        Thread thread = new Thread(printer);
        thread.start();
        //This will work as normal method & using main thread
        printer.run();
        System.out.println("Main is executing in "+Thread.currentThread().getName());
    }
}

package IntroToMultiThreading;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrinter printer = new HelloWorldPrinter();
        Thread thread = new Thread(printer);
        thread.start();
        System.out.println("Main is executing in "+Thread.currentThread().getName());
    }
}

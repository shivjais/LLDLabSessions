package IntroToMultiThreading.NumberPrinter;

//This will print number from 1 to n
public class Client {
    public static void main(String[] args) {

        for (int i = 1;i<=100;i++){
            NumberPrinter printer = new NumberPrinter(i);
            Thread thread = new Thread(printer);
            thread.start();
        }
    }
}

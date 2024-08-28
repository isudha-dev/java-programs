package concepts.Concurrency;

public class NumberPrinterMain {

    // print number 1 to 100 from different threads

    public static void main(String[] args) {
        for(int i = 0; i <= 99; i++){
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);
            t.start();
        }
    }

}

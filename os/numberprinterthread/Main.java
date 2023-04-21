package os.numberprinterthread;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting to print number in thread " + Thread.currentThread().getName());

        for (int i = 1; i <= 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);
            t.start();
        }

    }

}
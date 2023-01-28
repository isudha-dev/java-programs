package numberprinteres;

public class NumberPrinter implements Runnable {
    private int numToPrint;

    public NumberPrinter(int numToPrint) {
        this.numToPrint = numToPrint;
    }

    @Override
    public void run() {
        System.out.println("Printing " + numToPrint + " from thread " + Thread.currentThread().getName());

    }

}

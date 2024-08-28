package concepts.Concurrency;

public class PrintEvenOddNumbers{
    private int max;
    private volatile boolean isOdd = true;

    public PrintEvenOddNumbers(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (this) {
            for (int i = 1; i <= max; i += 2) {
                while (!isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
                isOdd = false;
                notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            for (int i = 2; i <= max; i += 2) {
                while (isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
                isOdd = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        int max = 10;
        PrintEvenOddNumbers printer = new PrintEvenOddNumbers(max);

        Thread oddThread = new Thread(printer::printOdd, "OddThread");
        Thread evenThread = new Thread(printer::printEven, "EvenThread");

        oddThread.start();
        evenThread.start();
    }
}

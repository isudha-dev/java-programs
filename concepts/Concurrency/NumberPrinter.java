package concepts.Concurrency;

public class NumberPrinter implements Runnable{
    int noToPrint;
    public NumberPrinter(int noToPrint){
        this.noToPrint = noToPrint;
    }

    @Override public void run() {
        // print the number
        System.out.println(noToPrint +" "+ Thread.currentThread().getName());
    }
}

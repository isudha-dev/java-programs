package os.addersubtractorsync;

public class Adder implements Runnable {
    Count count;

    Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++)
            synchronized (count) {
                count.val += i;
            }
    }
}

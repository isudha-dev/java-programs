package os.addersubtractorsync;

public class Subtractor implements Runnable {
    Count count;

    Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++)
            synchronized (count) {
                count.val -= i;
            }

    }

}

package lld.designpatterns.singleton;

public class Client implements Runnable {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Client());
        Thread t2 = new Thread(new Client());
        Thread t3 = new Thread(new Client());
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();
        SingletonClass s3 = SingletonClass.getInstance();
    }

}

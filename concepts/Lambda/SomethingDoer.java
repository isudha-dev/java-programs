package javas.Lambda;

public class SomethingDoer implements Runnable{

    @Override public void run() {
        System.out.println("This is v1 for runnable");
    }
}

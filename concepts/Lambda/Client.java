package concepts.Lambda;

public class Client {

    public static void main(String[] args) {
        /*
            v1
            need to create class (interface variable) with implementation of 1 method
            then call the necessary method to execute
         */
        SomethingDoer sd = new SomethingDoer();
        Thread t1 = new Thread(sd);
        t1.start();

        Bird b1 = new Bird();
        b1.fly();

        /*
            v2
           using lambda, no need to create separate class (interface variable)
         */

        Runnable r = () -> {
            System.out.println("This is v2 for runnable");
        };
        Thread t2 = new Thread(r);
        t2.start();

        Flyable f = () -> {
            System.out.println("Flying from lambda v2");
        };
        f.fly();

        /*
            v3
            interface variable is used only once, hence we can avoid creating it altogether.
         */

        Thread t3 = new Thread(
            () -> {
                System.out.println("This is v3 for runnable");
            }
        );
        t3.start();




    }

}

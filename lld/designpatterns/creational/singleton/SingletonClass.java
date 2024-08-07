package lld.designpatterns.creational.singleton;

public class SingletonClass {
    private static SingletonClass instance;

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }

        return instance;
    }

    /*
    public static SingletonClass getInstance() {
        if (instance == null) {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", entering first if");
            synchronized (SingletonClass.class) {
                System.out.println("Thread: " + Thread.currentThread().getName() + ", entering synchronize");
                if (instance == null) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + ", entering second if");
                    instance = new SingletonClass();
                    System.out.println("Thread: " + Thread.currentThread().getName() + ", exiting second if");
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + ", exiting synchronize");
            }
            System.out.println("Thread: " + Thread.currentThread().getName() + ", exiting first if");
        }

        return instance;
    }
     */

}

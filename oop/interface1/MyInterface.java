package oop.interface1;

public interface MyInterface {
    static int i = 100;
    int j = 200;
    public int k = 300;

    default void defaultMethod(){
        System.out.println("This is default method");
    }

    static void staticMethod(){
        System.out.println("This is static method");
    }

    void abstractMethod();

}

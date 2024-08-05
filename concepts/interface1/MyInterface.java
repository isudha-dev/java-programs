package oop.interface1;

public interface MyInterface {
    int i = 100;
    int j = 200;
    int k = 300;

    default void defaultMethod1(){
        System.out.println("This is default method1 from interface");
    }

    default void defaultMethod2(){
        System.out.println("This is default method2 from interface");
    }

    static void staticMethod(){
        System.out.println("This is static method from interface");
    }

    void abstractMethod1();

    void abstractMethod2();

}

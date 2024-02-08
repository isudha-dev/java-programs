package oop.interface1;

public interface I1 {

    void foo();
    void foo1();

    default void foo3() {
        System.out.println("Default method of interface 1");
    }

    default void foo4(){
        System.out.println("Default unique method");
    }
}

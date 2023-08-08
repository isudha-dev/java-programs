package oop.interface1;

public class ImplementingClass1 implements MyInterface{

    @Override
    public void defaultMethod() {
        MyInterface.super.defaultMethod();
        System.out.println("Child default method");
    }

    @Override
    public void abstractMethod() {
        System.out.println("Child abstract method");
    }

    public void display(){
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}

package oop.abstract1;

public class ExtendingClass1 extends MyAbstractClass{

    protected void protectedMethod(){
        super.defaultMethod();
        System.out.println("ExtendingClass1 protected method");
    }
    void defaultMethod() {
        super.protectedMethod();
        System.out.println("ExtendingClass1 default method");
    }

//    @Override
//    void abstractMethod() {
//        System.out.println("ExtendingClass1 abstract method");
//    }
}

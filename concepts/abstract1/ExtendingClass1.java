package oop.abstract1;

public class ExtendingClass1 extends MyAbstractClass{

    int i = 105;
    public int j = 205;
    protected int k = 305;
    static int m = 505;
    static void staticMethod(){
        MyAbstractClass.staticMethod();
        System.out.println("ExtendingClass1 static method");
    }

    protected void protectedMethod(){
        super.protectedMethod();
        System.out.println("ExtendingClass1 protected method");
    }
    void defaultMethod() {
        super.defaultMethod();
        System.out.println("ExtendingClass1 default method");
    }

    public void publicMethod(){
        super.publicMethod();
        System.out.println(super.i);
        System.out.println(super.j);
        System.out.println(super.k);
        System.out.println(MyAbstractClass.m);
    }


//    @Override
//    void abstractMethod() {
//        System.out.println("ExtendingClass1 abstract method");
//    }
}

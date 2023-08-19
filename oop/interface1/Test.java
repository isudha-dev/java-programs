package oop.interface1;

public class Test {

    public static void main(String[] args) {
        ImplementingClass1 ic = new ImplementingClass1();
        ic.defaultMethod();
        ic.abstractMethod1();
        ic.abstractMethod2();
        ic.display();
        System.out.println(ic.k);
        MyInterface.staticMethod();
    }

}

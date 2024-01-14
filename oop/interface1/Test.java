package oop.interface1;

public class Test {

    public static void main(String[] args) {
        MyInterface.staticMethod();

        ImplementingClass1 ic = new ImplementingClass1(10);
        ic.defaultMethod1();
        ic.defaultMethod2();
        ic.abstractMethod1();
        ic.abstractMethod2();
        ic.display();
        ic.callingStaticMethod();
        ImplementingClass1.staticMethod();
        System.out.println(ic.i + " "+ ic.j+" "+ImplementingClass1.k);

    }

}

package oop.abstract1;

public class Test {

    public static void main(String[] args) {
        ExtendingClass1 ec = new ExtendingClass1();
        ec.publicMethod();
        ec.defaultMethod();
        ec.protectedMethod();
        System.out.println(ec.i);
        System.out.println(ec.j);
        System.out.println(ec.k);

        ExtendingClass1.staticMethod();
        System.out.println(ExtendingClass1.m);
    }

}

package concepts.abstractclass;

public class Test {

    public static void main(String[] args) {
        ExtendingClass ec = new ExtendingClass();
        ec.publicMethod();
        ec.defaultMethod();
        ec.protectedMethod();
        ExtendingClass.staticMethod();
        System.out.println("\nPrinting from client");
        System.out.println(ec.i);
        System.out.println(ec.j);
        System.out.println(ec.k);
        System.out.println(ExtendingClass.m);
    }

}

package concepts.abstract1;

public class ExtendingClass extends MyAbstractClass{

    int i = 105;
    public int j = 205;
    protected int k = 305;
    static int m = 505;
    static void staticMethod(){
        System.out.println("\n");
        MyAbstractClass.staticMethod();
        System.out.println("ExtendingClass static method");
        System.out.println("ExtendingClass static var " +m);
        System.out.println("MyAbstractClass static var " +MyAbstractClass.m);
    }

    protected void protectedMethod(){
        System.out.println("\n");
        super.protectedMethod();
        System.out.println("ExtendingClass protected method");
        System.out.println("ExtendingClass protected var " +k);
        System.out.println("MyAbstractClass protected var " +super.k);
    }
    void defaultMethod() {
        System.out.println("\n");
        super.defaultMethod();
        System.out.println("ExtendingClass default method");
        System.out.println("ExtendingClass default var " +i);
        System.out.println("MyAbstractClass default var " +super.i);
    }

    public void publicMethod(){
        System.out.println("\n");
        super.publicMethod();
        System.out.println("ExtendingClass public method");
        System.out.println("ExtendingClass public var " +j);
        System.out.println("MyAbstractClass public var " +super.j);
    }


    @Override
    void abstractMethod() {
        System.out.println("ExtendingClass abstract method");
    }
}

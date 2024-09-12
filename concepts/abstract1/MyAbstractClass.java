package concepts.abstract1;

public abstract class MyAbstractClass {


    int i = 100;
    public int j = 200;
    protected int k = 300;
    private int l = 400;
    static int m = 500;

    static void staticMethod(){
        System.out.println("MyAbstractClass static method");
        System.out.println("MyAbstractClass static var " +m);
    }

    private void privateMethod(){
        System.out.println("MyAbstractClass private method");
        System.out.println("MyAbstractClass private var " +l);
    }

    void defaultMethod() {
        System.out.println("MyAbstractClass default method");
        System.out.println("MyAbstractClass default var " +i);
    }

    protected void protectedMethod(){
        System.out.println("MyAbstractClass protected method");
        System.out.println("MyAbstractClass protected var " +k);
    }

    public void publicMethod() {
        System.out.println("MyAbstractClass public method");
        System.out.println("MyAbstractClass static var " +j);
    }

    abstract void abstractMethod();

}

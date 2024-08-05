package oop.abstract1;

public abstract class MyAbstractClass {


    int i = 100;
    public int j = 200;
    protected int k = 300;
    private int l = 400;
    static int m = 500;

    static void staticMethod(){
        System.out.println("MyAbstractClass static method");
    }

    private void privateMethod(){
        System.out.println("MyAbstractClass private method");
    }

    void defaultMethod() {
        System.out.println("Private var i: "+ i);
        System.out.println("Private var l: "+ l);
        System.out.println("MyAbstractClass default method");
    }

    protected void protectedMethod(){
        System.out.println("MyAbstractClass protected method");
    }

    public void publicMethod() {
        System.out.println("MyAbstractClass public method");
    }

//    abstract void abstractMethod();

}

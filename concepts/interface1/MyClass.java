package oop.interface1;

public class MyClass implements I1, I2{

    @Override
    public void foo() {

    }

    @Override
    public void foo2() {

    }

    @Override
    public void foo1() {

    }

    @Override
    public void foo3() {
        System.out.println("Default method from child class");
    }

    @Override
    public void foo4(){
        // child class can override default behaviour.
        System.out.println("child class can override default behaviour.");
    }

    public static int someMethod(int i){
        try {
            //some statement
//            System.out.println(i+" try");
            throw new Exception();
//            return i;
        } catch(Exception e) {
            //some statement
            System.out.println(i+" catch");
            return i;
        } finally {
            //finally block statements
            System.out.println("In finally");
        }
    }

    public static void main(String[] args) {
        someMethod(5);

        MyClass mc = new MyClass();
        mc.foo3();
        mc.foo4();

        int i = 0;
        try {
            i = 100 / 0;
        } catch (ArithmeticException e){
            throw new ArithmeticException("math");
        }
        finally {
            throw new RuntimeException("Hello");
        }
    }
}

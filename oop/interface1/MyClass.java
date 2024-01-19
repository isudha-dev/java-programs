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
    }
}

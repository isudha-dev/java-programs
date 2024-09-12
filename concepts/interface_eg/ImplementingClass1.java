package concepts.interface_eg;

public class ImplementingClass1 implements MyInterface{

    public ImplementingClass1(int p){
        System.out.println(p);
    }

    @Override
    public void defaultMethod1() {
        MyInterface.super.defaultMethod1();
        System.out.println("Child default method1");
    }

    @Override
    public void defaultMethod2() {
//        MyInterface.super.defaultMethod2();
        System.out.println("Child default method2, not calling interface implementation");
    }

    @Override public void abstractMethod1() {
        System.out.println("Child abstract method1");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("Child abstract method2");
    }

    public void display(){
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    public void callingStaticMethod(){
        MyInterface.staticMethod();
    }

    static void staticMethod(){
        System.out.println("Static method from implementing class");
    }
}

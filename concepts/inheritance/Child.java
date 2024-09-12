package concepts.inheritance;

public class Child extends Parent {
    public int a3;

    // if parent class has default constructor, then child class doesn't need to
    // have super() in its constructor

    // if parent class does not have default constructor, then child class must call
    // super() to call parent constructor in its constructor method

    public Child(int a3) {
        super(a3, a3); // constructor chaining
        this.a3 = a3;
    }

    public void m3() {
        System.out.println("Child m3");
    }

}

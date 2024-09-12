package concepts.anonclass;

public class Main {
    public static void main(String[] args) {
        // Creating an anonymous class that implements an interface
        MyInterface myObject = new MyInterface() {

            public void innerMethod(){
                System.out.println("This is the inner method in the anonymous class. It can not be called from outside");
            }
            @Override
            public void display() {
                System.out.println("This is the display method in the anonymous class.");
            }

            @Override
            public void myMethod() {
                System.out.println("This is a custom method in the anonymous class.");
                innerMethod();
            }
        };

        // Calling methods from the anonymous class
        myObject.display();
        myObject.myMethod();
//        myObject.innerMethod(); this method can not be called because interface does not have this
    }
}

// Interface with methods
interface MyInterface {
    void display();
    void myMethod();
}
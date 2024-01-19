package oop.constructor;

public class DeepCopyExample {
    public static void main(String[] args) {
        // Creating an object
        MyClass original = new MyClass(1, new MyInnerClass(10));

        // Deep copy using a custom method
        MyClass deepCopy = original.deepCopy();

        // Modifying the content of the copied object
        deepCopy.setValue(2);
        deepCopy.getInner().setInnerValue(20);

        // Original object and deep copy have independent inner objects
        System.out.println(original);     // Output: MyClass{value=1, inner=MyInnerClass{innerValue=10}}
        System.out.println(deepCopy);    // Output: MyClass{value=2, inner=MyInnerClass{innerValue=20}}
    }
}


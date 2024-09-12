package concepts.constructor;

public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Creating an object
        MyClass original = new MyClass(1, new MyInnerClass(10));

        // Shallow copy using clone() method
        MyClass shallowCopy = (MyClass) original.clone();

        // Modifying the content of the copied object
        shallowCopy.setValue(2);
        shallowCopy.getInner().setInnerValue(20);

        // Original object and shallow copy refer to the same inner object
        System.out.println(original);       // Output: MyClass{value=1, inner=MyInnerClass{innerValue=20}}
        System.out.println(shallowCopy);   // Output: MyClass{value=2, inner=MyInnerClass{innerValue=20}}
    }
}

class MyClass implements Cloneable {
    private int value;
    private MyInnerClass inner;
    public MyClass(int i, MyInnerClass myInnerClass) {
        value = i;
        inner = myInnerClass;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public MyInnerClass getInner() {
        return inner;
    }
    public void setInner(MyInnerClass inner) {
        this.inner = inner;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MyClass deepCopy() {
        return new MyClass(this.value, new MyInnerClass(this.inner.getInnerValue()));
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "value=" + value +
                ", inner=" + inner +
                '}';
    }
}

class MyInnerClass {
    private int innerValue;
    public MyInnerClass(int i) {
        innerValue = i;
    }
    public int getInnerValue() {
        return innerValue;
    }
    public void setInnerValue(int innerValue) {
        this.innerValue = innerValue;
    }

    @Override
    public String toString() {
        return "MyInnerClass{" +
                "innerValue=" + innerValue +
                '}';
    }
}


package concepts.interface1;

public interface I2 {
    void foo();
    void foo2();

    default void foo3() {
        System.out.println("Default method of interface 2");
    }
}

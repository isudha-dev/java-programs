package javas.Generics;

public class Animal {
    String name;
    String color;
    int age;

    public Animal(final String name, final String color, final int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    @Override public String toString() {
        return "Animal{" +
            "name='" + name + '\'' +
            ", color='" + color + '\'' +
            ", age=" + age +
            '}';
    }
}

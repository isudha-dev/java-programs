package javas.Generics;

public class Dog extends Animal{
    boolean domestic;

    public Dog( String name,  String color,  int age, boolean domestic) {
        super(name, color, age);
        this.domestic = domestic;
    }

    @Override public String toString() {
        return "Dog{" +
            "domestic=" + domestic +
            ", name='" + name + '\'' +
            ", color='" + color + '\'' +
            ", age=" + age +
            '}';
    }
}

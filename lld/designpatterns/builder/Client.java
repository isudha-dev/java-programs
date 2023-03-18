package lld.designpatterns.builder;

public class Client {

    public static void main(String[] args) {
        Student s = Student.builder()
                .setName("Sudha")
                .setAge(32)
                .setGradyear(2010)
                .setYoe(12)
                .build();

        s.print();
    }

}

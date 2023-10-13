package javas.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        Student s1 = new Student("Sudha", 1, 97.5);
        Student s2 = new Student("Shailesh", 2, 100.0);
        Student s3 = new Student("Sia", 3, 10.0);

        List<Student> studentList = List.of(s1, s2, s3); // List.of() creates immutable list and can not be modified.
        studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Collections.sort(studentList);
        studentList.stream().forEach(student -> System.out.println(student.name));

        Collections.sort(studentList, new StudentPspComparator());
        studentList.stream().forEach(student -> System.out.println(student.psp));

    }

}

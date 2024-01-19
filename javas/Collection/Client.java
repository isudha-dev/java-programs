package javas.Collection;

import java.util.*;

public class Client {

    public static void main(String[] args) {

        Student s1 = new Student("Sudha", 1, 975);
        Student s2 = new Student("Shailesh", 2, 1000);
        Student s3 = new Student("Sia", 3, 100);

        List<Student> studentList1 = List.of(s1, s2, s3); // List.of() creates immutable list and can not be modified.
        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(s1);
        studentList2.add(s2);
        studentList2.add(s3);

        Collections.sort(studentList2);
        studentList2.forEach(student -> System.out.println(student.name));

        studentList2.sort(new StudentPspComparator());
        studentList2.forEach(student -> System.out.println(student.psp));


        studentList2.sort(Comparator.comparingInt(o -> o.id));
        /* anonymous comparator class
            studentList2.sort((o1, o2) -> {
                return o1.id - o2.id;
            });
         */
        studentList2.forEach(student -> System.out.println(student.id));

    }

}

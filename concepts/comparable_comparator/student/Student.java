package concepts.comparable_comparator.student;

public class Student implements Comparable<Student>{
    String name;
    int id;
    int psp;

    public Student(final String name, final int id, final int psp) {
        this.name = name;
        this.id = id;
        this.psp = psp;
    }
    @Override
    public int compareTo(Student other) {
//        return this.name.compareTo(other.name);
        if(this.name.equals(other.name)) return 0;
        if(this.name.compareTo(other.name) < 0) return -1;
        return 1;
    }

    /*
        In Java, comparison methods typically return an integer value:
            0 if the objects are equal.
                order of objects does not matter
            A negative value if the first object is considered "less than" the second.
                first object comes before second object
            A positive value if the first object is considered "greater than" the second.
               second object comes before first object

        Ascending Order (a,b) -> (a - b)
            a=5,  b=10 => 5 - 10 => negative => so a=5 comes before b=10
            a=12, b=7 => 12 - 7 => positive => so b=7 comes before a=12
        Descending Order (a,b) -> (b - a)
            a=5, b=10 => 10 - 5 => positive => so b=10 comes before a=5
            a=12, b=7 => 7 - 12 => negative => so a=12 come before b=7

        Ascending order:
            Arrays.sort(fruits, (a, b) -> a.compareTo(b));
        Descending order:
            Arrays.sort(fruits, (a, b) -> b.compareTo(a));
     */

}

package javas.Collection;

public class Student implements Comparable<Student>{
    String name;
    int id;
    Double psp;

    public Student(final String name, final int id, final Double psp) {
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
        this ---- other
        < 0 ---- this is smaller than other. this < other
        = 0 ---- this is equal to other. Put them in any order.
        > 0 ---- this is greater than other. other < this
     */

}

package concepts.comparable_comparator.student;

import java.util.Comparator;

public class StudentPspComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.psp, o2.psp); // ascending
//        return Integer.compare(o2.psp, o1.psp); // descending
//        if(o1.psp > o2.psp) return -1;
//        if(o1.psp < o2.psp) return 1;
//        return 0;

    }
}

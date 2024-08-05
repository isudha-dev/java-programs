package javas.Collection;

import java.util.Comparator;

public class StudentPspComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.psp > o2.psp) return -1;
        if(o1.psp < o2.psp) return 1;
        return 0;

        /*
            if o1 should come before o2 -> return -1
            if o2 should come before o1 -> return 1
         */
    }
}

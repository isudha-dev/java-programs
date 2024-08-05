package oop.comparable_comparator;

import java.util.Comparator;

public class TitleCompare implements Comparator<Song> {

    @Override public int compare(final Song o1, final Song o2) {
        return o1.title.compareTo(o2.title);
    }
}

package concepts.comparable_comparator.song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Song s1 = new Song("Zara si dil me", "Sayeed Quadi", "Kk", 30);
        Song s2 = new Song("Aashiqui mein har aashiq", "Sameer", "Kumar sanu", 30);
        Song s3 = new Song("Pehla pehla pyar hai ", "Dev kohli", "S P Balasubramaniam", 20);
        Song s4 = new Song("Jaane kya dhoondta hai", "Muqtida Hasan", "Lucky Ali", 10);

        List<Song> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        System.out.println("Before " + list1);
        // default sort from Song object
        Collections.sort(list1);
        System.out.println("After default compare " + list1);

        TitleCompare titleCompare = new TitleCompare();
        // Comparator implemented in separate class
        list1.sort(titleCompare);
        System.out.println("After title compare " + list1);

        WriterCompare writerCompare = new WriterCompare();
        // Comparator implemented as inner class here
        list1.sort(writerCompare);
        System.out.println("After writer compare " + list1);

        // lambda comparator
        //        list1.sort((o1, o2) -> {
        //            return o1.singer.compareTo(o2.singer);
        //        });
        list1.sort(Comparator.comparing(o -> o.singer)); // 1.8 update
        System.out.println("After singer compare " + list1);

    }

    static class WriterCompare implements Comparator<Song> {

        @Override public int compare(final Song o1, final Song o2) {
            return o1.writer.compareTo(o2.writer);
        }
    }

}

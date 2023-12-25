package dsa.twodarray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class Practise extends Thread {
    public void run(){
        System.out.println("running...");
    }
    public static void main(String[] args) {
        SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = fo.parse("31/03/2015");
            System.out.println(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}


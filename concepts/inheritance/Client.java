package concepts.inheritance;

public class Client {

    public static void main(String[] args) {
//        Child c1 = (Child) new Parent(5,7); // needs explicit casting but still doesn't work, gives ClassCastException
        Parent p1 = new Child(3);

        Child c2 = new Child(10);
        Parent p2 = new Parent(10,23);


        // can by default cast smaller to bigger, but not otherwise
        // eg. casting int to long is auto, but long to int needs explicit casting

        int i1 = 5;
        long l = i1;

        long l2 = 100024l;
        int i2= (int) l2;

//        c1.m1();
//        c1.m2();
//        c1.m3();

        System.out.println("---Parent p1");
        p1.m1();
        p1.m2();

        System.out.println("---Child c2");
        c2.m1();
        c2.m2();
        c2.m3();

        System.out.println("---Parent p2");
        p2.m1();
        p2.m2();

    }

}

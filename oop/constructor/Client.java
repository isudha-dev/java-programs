package oop.constructor;

public class Client {

    public static void main(String[] args) {
        Constructor cc1 = new Constructor(1, 2);
        Constructor cc2 = new Constructor(cc1); // deep copy // copy constructor
        System.out.println("Deep copy cc2 from cc1");
        System.out.println("cc1 attributes");
        System.out.println(cc1.getAttr1());
        System.out.println(cc1.getAttr2());
        System.out.println("cc2 attributes");
        System.out.println(cc2.getAttr1());
        System.out.println(cc2.getAttr2());

        Constructor cc3 = cc1; // shallow copy
        System.out.println("Shallow copy cc3 from cc1");
        System.out.println("cc3 attributes");
        System.out.println(cc3.getAttr1());
        System.out.println(cc3.getAttr2());

        cc3.setAttr1(5);
        System.out.println("Changing cc3 val");
        System.out.println("cc1 attributes");
        System.out.println(cc1.getAttr1());
        System.out.println(cc1.getAttr2());

        System.out.println("cc2 attributes");
        System.out.println(cc2.getAttr1());
        System.out.println(cc2.getAttr2());

        System.out.println("cc3 attributes");
        System.out.println(cc3.getAttr1());
        System.out.println(cc3.getAttr2());

    }

}

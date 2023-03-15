package oop.accessmodifier.firstpkg;

public class Child extends Parent {

    public static void main(String[] args) {

        System.out.println("Public parent " + p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + p_def_attr);
        System.out.println("Protected parent " + p_prtcd_attr);
    }

}

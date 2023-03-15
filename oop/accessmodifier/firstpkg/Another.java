package oop.accessmodifier.firstpkg;

public class Another {
    public static void main(String[] args) {

        System.out.println("Public parent " + Parent.p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + Parent.p_def_attr);
        System.out.println("Protected parent " + Parent.p_prtcd_attr);
    }
}

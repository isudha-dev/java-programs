package oop.accessmodifier.firstpkg;

public class Child extends Parent {
    public static void staticMethod() {

        System.out.println("Public parent " + Parent.p_st_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + Parent.p_st_def_attr);
        System.out.println("Protected parent " + Parent.p_st_prtcd_attr);
    }

    public void nonStaticMethod(){
        System.out.println("Public parent " + p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + p_def_attr);
        System.out.println("Protected parent " + p_prtcd_attr);
    }

}

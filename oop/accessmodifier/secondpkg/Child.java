package oop.accessmodifier.secondpkg;

import oop.accessmodifier.firstpkg.Parent;

public class Child extends Parent {

    public static void staticMethod() {

        System.out.println("Public parent " + Parent.p_st_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + "not accessible Parent.p_st_def_attr"); // was accessible within same package
        System.out.println("Protected parent " + Parent.p_st_prtcd_attr);
    }

    public void nonStaticMethod(){
        System.out.println("Public parent " + p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + "not accessible p_def_attr"); // was accessible within same package
        System.out.println("Protected parent " + p_prtcd_attr);
    }

}

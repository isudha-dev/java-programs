package oop.accessmodifier.secondpkg;

import oop.accessmodifier.firstpkg.Parent;

public class Another {
    public static void staticMethod() {

        System.out.println("Public parent " + Parent.p_st_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + "not accessible Parent.p_st_def_attr"); // was accessible within same package
        System.out.println("Protected parent " + "not accessible Parent.p_st_prtcd_attr"); // was accessible within same package
    }

    public void nonStaticMethod(){
        Parent p = new Parent();
        System.out.println("Public parent " + p.p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + "not accessible p.p_def_attr"); // was accessible within same package
        System.out.println("Protected parent " + "not accessible p.p_prtcd_attr"); // was accessible within same package
    }
}

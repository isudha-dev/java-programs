package concepts.accessmodifier.firstpkg;

public class Child extends Parent {
    public static void staticMethod() {
        System.out.println("Public parent " + p_st_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + p_st_def_attr);
        System.out.println("Protected parent " + p_st_prtcd_attr);
    }

    public void nonStaticMethod(){
        System.out.println("Public parent " + p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + p_def_attr);
        System.out.println("Protected parent " + p_prtcd_attr);
    }

}

package concepts.accessmodifier.firstpkg;

public class Another {
    public static void staticMethod() {
        System.out.println("Public parent " + Parent.p_st_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + Parent.p_st_def_attr);
        System.out.println("Protected parent " + Parent.p_st_prtcd_attr);
    }

    public void nonStaticMethod(){
        Parent p = new Parent();
        System.out.println("Public parent " + p.p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + p.p_def_attr);
        System.out.println("Protected parent " + p.p_prtcd_attr);
    }
}

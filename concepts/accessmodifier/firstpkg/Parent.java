package concepts.accessmodifier.firstpkg;

public class Parent {
    static private int p_st_pvt_attr;
    static public int p_st_public_attr;
    static int p_st_def_attr; // package protected
    static protected int p_st_prtcd_attr;

    private int p_pvt_attr;
    public int p_public_attr;
    int p_def_attr; // package
    protected int p_prtcd_attr;

    public static void main(String[] args) {
        System.out.println(p_st_pvt_attr);
        Parent p = new Parent();
        System.out.println(p.p_pvt_attr);
    }

//     public - visible everywhere
//     private - visible nowhere, just within class
//
//     default - visible only within same package, to both child and non-child class.
//     child class will access without instantiating and non-child class will need an instance
//
//     protected - visible to child class everywhere. Within package, also visible to non-child classes.
//     child class will access without instantiating and non-child class will need an instance

}
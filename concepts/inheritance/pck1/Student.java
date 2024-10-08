package concepts.inheritance.pck1;

public class Student extends User {

    private int age;
    protected Address saddress;
    protected String sFullAddress;
    String sdesignation;
    public String sname;
    public Student(final int sage, final String sFullAddress, final String sdesignation, final String sname) {
        super(sage,sFullAddress,sdesignation,sname);
        this.age = sage;
        this.sFullAddress = sFullAddress + " student";
        this.sdesignation = sdesignation + " student";
        this.sname = sname + " student";
    }

    void displayUser(){
//        System.out.println(super.age); private access in parent
        System.out.println(fullAddress);
        System.out.println(designation);
        System.out.println(name);
    }

    void displayStudent(){
        System.out.println(age);
        System.out.println(sFullAddress);
        System.out.println(sdesignation);
        System.out.println(sname);
    }

    private void displayAge(){
//        super.displayAge(); private access
        System.out.println(age);
    }

    protected void displayAddress(){
        super.displayAddress();
        System.out.println(sFullAddress);
    }

    void displayDesignation(){
        super.displayDesignation();
        System.out.println(sdesignation);
    }

    public void displayName(){
        super.displayName();
        System.out.println(sname);
    }

//    can not override final method
//    public final void finalMethod(){
//        System.out.println("This is final method");
//    }



}

package oop.inheritance.pck2;

import oop.inheritance.pck1.User;

public class Student extends User {

    private int sage;
    protected String sFullAddress;
    String sdesignation;
    public String sname;
    public Student(final int sage, final String sFullAddress, final String sdesignation, final String sname) {
        super(sage,sFullAddress,sdesignation,sname);
        this.sage = sage;
        this.sFullAddress = sFullAddress + " student";
        this.sdesignation = sdesignation + " student";
        this.sname = sname + " student";
    }

    void displayUser(){
//        System.out.println(age); private access in parent
        System.out.println(fullAddress);
//        System.out.println(designation); not public in User
        System.out.println(name);
    }

    void displayStudent(){
        System.out.println(sage);
        System.out.println(sFullAddress);
        System.out.println(sdesignation);
        System.out.println(sname);
    }

    private void displayAge(){
//        super.displayAge(); private access
        System.out.println(sage);
    }

    protected void displayAddress(){
        super.displayAddress();
        System.out.println(sFullAddress);
    }

    void displayDesignation(){
//        super.displayDesignation(); not public
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

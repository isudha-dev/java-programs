package oop.inheritance.pck1;

public class Student1 {
    void displayUser(){
        User u = new User(10,"","","");
//        System.out.println(u.age); private access
        System.out.println(u.fullAddress);
        System.out.println(u.designation);
        System.out.println(u.name);

    }

}

package oop.inheritance.pck2;

import oop.inheritance.pck1.User;

public class Student1 {
    void displayUser(){
        User u = new User(10,"","","");
//        System.out.println(u.age); private access
//        System.out.println(u.fullAddress); protected access
//        System.out.println(u.designation); not public
        System.out.println(u.name);

    }

}

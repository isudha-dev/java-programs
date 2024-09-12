package concepts.inheritance.pck2;

import concepts.inheritance.pck1.User;

public class Client {
    void displayUser(){
        User u = new User(10,"","","");
//        System.out.println(u.age); private access
//        System.out.println(u.fullAddress); protected access
//        System.out.println(u.designation); default public
        System.out.println(u.name);

    }

}

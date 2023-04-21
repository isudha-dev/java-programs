package oop.inheritance.pck1;

public class User {
    private int age;
    protected Address address;
    String designation;
    public String name;


    class Address{
        void display(){
            System.out.println(age);
            System.out.println(address);
            System.out.println(name);
            System.out.println(designation);
        }
    }
}

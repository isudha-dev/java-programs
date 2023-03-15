package oop.accessmodifier.secondpkg;

import oop.accessmodifier.firstpkg.Parent;

public class Another {
    public static void main(String[] args) {

        System.out.println("Public parent " + Parent.p_public_attr);
        System.out.println("Private parent " + "not accessible");
        System.out.println("Default parent " + "not accessible");
        System.out.println("Protected parent " + "not accessible");
    }
}

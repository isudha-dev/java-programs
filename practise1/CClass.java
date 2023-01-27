package practise1;

import practise.AClass;

public class CClass extends AClass {

    void method1() {

        AClass a = new AClass();
        a.pubInt = 15;
        a.proInt = 17;
        // a.defInt = 20;

        AClass.pubStInt = 25;
        AClass.proStInt = 27;
        // AClass.defStInt = 30;

        System.out.println("Public " + a.pubInt);
        System.out.println("Protected " + a.proInt);
        // System.out.println("Default " + a.defInt);

        System.out.println("Public static " + AClass.pubStInt);
        System.out.println("Protected static " + AClass.proStInt);
        // System.out.println("Default static " + AClass.defStInt);

    }

    public static void main(String[] args) {
        CClass c = new CClass();
        c.method1();
    }

}

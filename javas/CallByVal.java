package javas;

import java.util.ArrayList;

public class CallByVal {

    public static void main(String[] args) {
        foo();
        /*
        prints 1 1 2
        this is because foo2() stores reference of 'list' object (which is original list from foo()
        but when 'list' is reinitialised in foo2(), ref of 'list' object now points to newly created list object
        this does not change list object of foo() method. Hence size remains 1 for 'list object

        Now when foo3() is called, it refers to original list object. And when new element is added to list here, it
        modifies the original object. Hence, finally we print the size of 2.

         */
    }

    static void foo() {
        ArrayList list = new ArrayList();
        list.add(1);

        System.out.println(list.size());//1

        foo2(list);

        System.out.println(list.size());//0

        foo3(list);
        System.out.println(list.size());//1
    }

    static void foo2(ArrayList list) {
        list = new ArrayList();
    }

    static void foo3(ArrayList list) {
        list.add(2);
    }
}

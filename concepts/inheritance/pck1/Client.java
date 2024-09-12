package concepts.inheritance.pck1;

public class Client {

    public static void main(String[] args) {
        User u = new User(10, "address line 1", "Dev", "Sudha");
        u.displayAddress();
        u.displayDesignation();
        u.displayName();
        System.out.println();

        Student st = new Student(20, "address line 2", "Test", "Kumar");
        st.displayUser();
        st.displayAddress();
        st.displayDesignation();
        st.displayName();
        st.displayStudent();
        System.out.println();

        User u1 = new Student(30, "address line 3", "Ops", "Shail");
        u1.displayAddress();
        u1.displayDesignation();
        u1.displayName();
        System.out.println();
    }

}

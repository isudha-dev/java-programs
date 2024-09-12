package concepts.inheritance.pck1;

public class User {
    private int age;
    protected String fullAddress;
    String designation;
    public String name;

    public User(final int age, final String fullAddress, final String designation, final String name) {
        this.age = age + 10;
        this.fullAddress = fullAddress + " user";
        this.designation = designation + " user";
        this.name = name + " user";
    }
    private void displayAge(){
        System.out.println(age);
    }

    protected void displayAddress(){
        System.out.println(fullAddress);
    }

    void displayDesignation(){
        System.out.println(designation);
    }

    public void displayName(){
        System.out.println(name);
    }

    public final void finalMethod(){
        System.out.println("This is final method");
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", fullAddress='" + fullAddress + '\'' +
                ", designation='" + designation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    class Address{
        private String addressLine1;
        protected String addressLine2;
        String city;
        public int zip;
        public Address(final String addressLine1, final String addressLine2, final String city, final int zip) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.zip = zip;
        }

        public void displayParentClassAttrib(){
            System.out.println(age);
            System.out.println(fullAddress);
            System.out.println(designation);
            System.out.println(name);
        }

        @Override public String toString() {
            return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + zip + '\'' +
                '}';
        }
    }
}

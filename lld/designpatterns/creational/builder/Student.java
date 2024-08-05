package lld.designpatterns.creational.builder;

public class Student {

    private String name;
    private int age;
    private int gradYear;
    private int yoe;
    private int phoneNum;

    private Student(Builder b) {
        this.name = b.name;
        this.age = b.age;
        this.gradYear = b.gradYear;
        this.yoe = b.yoe;
        this.phoneNum = b.phoneNum;
    }

    public static Builder builder() {
        Builder b = new Builder();
        return b;
    }

    public void print() {
        System.out.println("Student name: " + name + "\nStudent age: " + age + "\nStudent gradyear: " + gradYear
                + "\nStudent yoe: " + yoe + "\nStudent phonenum: " + phoneNum);
    }

    static class Builder {
        private String name;
        private int age;
        private int gradYear;
        private int yoe;
        private int phoneNum;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGradyear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Builder setYoe(int yoe) {
            this.yoe = yoe;
            return this;
        }

        public Builder setphonenum(int phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public void validate() {
            if(name == null){
                throw new RuntimeException("Name is null");
            } else if (yoe < 1) {
                throw new RuntimeException("Year of experience is less than 1");
            } else if (gradYear < 2023) {
                throw new RuntimeException("Grad year should be 2022 or earlier");
            }
        }

        public Student build() {
            validate();
            Student s = new Student(this);
            return s;
        }
    }

}

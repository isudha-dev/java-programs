package lld.designpatterns.prototyperegistry;

public class Client {

  public static void main(String[] args) {
    Student aprBatch = new Student();
    aprBatch.setInstructorName("Sandeep");
    aprBatch.setBatchName("Apr 2022 Academy");
    aprBatch.setYearOfEnrollment(2022);
    aprBatch.setAvgBatchPsp(90.5);

    Student s1 = aprBatch.clone();
    s1.setId(1);
    s1.setName("Sudha");
    s1.setAge(32);

    System.out.println("Student s1: "+s1);

    SmartStudent aprBatchSmart = new SmartStudent();
    aprBatchSmart.setInstructorName("Naman");
    aprBatchSmart.setBatchName("Apr 2022 Academy Smart");
    aprBatchSmart.setYearOfEnrollment(2022);
    aprBatchSmart.setAvgBatchPsp(96);
    aprBatchSmart.setIq(160);

    SmartStudent s2 = aprBatchSmart.clone();
    s2.setId(2);
    s2.setName("Tushar");
    s1.setAge(25);

    System.out.println("Student s2: "+s2);

  }

}

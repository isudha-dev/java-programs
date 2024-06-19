package lld.designpatterns.creational.prototyperegistry.student;

public class ClientRegistry {

  public static void main(String[] args) {
    Student aprBatch = new Student();
    aprBatch.setInstructorName("Sandeep");
    aprBatch.setBatchName("Apr 2022 Academy");
    aprBatch.setYearOfEnrollment(2022);
    aprBatch.setAvgBatchPsp(90);

    Student mayBatch = new Student();
    mayBatch.setInstructorName("Kohli");
    mayBatch.setBatchName("May 2022 Academy");
    mayBatch.setYearOfEnrollment(2022);
    mayBatch.setAvgBatchPsp(96.5);

    Student junBatch = new Student();
    junBatch.setInstructorName("Rohit");
    junBatch.setBatchName("Jun 2022 Academy");
    junBatch.setYearOfEnrollment(2022);
    junBatch.setAvgBatchPsp(86);

    StudentRegistry registry = new StudentRegistry();
    registry.save(aprBatch);
    registry.save(mayBatch);
    registry.save(junBatch);

    Student aprBatchPrototype = registry.get(aprBatch.getBatchName());
    Student s1 = aprBatchPrototype.clone();
    s1.setId(1);
    s1.setName("Sudha");
    s1.setAge(32);

    Student mayBatchPrototype = registry.get(mayBatch.getBatchName());
    Student s2 = mayBatchPrototype.clone();
    s2.setId(2);
    s2.setName("Sia");
    s2.setAge(2);

    System.out.println(s1);
    System.out.println(s2);



  }

}

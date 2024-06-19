package lld.designpatterns.creational.prototyperegistry.student;

public class Student implements Prototype<Student>{
  private int id;
  private String name;
  private int age;
  private String instructorName;
  private String batchName;
  private int yearOfEnrollment;
  private double avgBatchPsp;

  public int getId() {
    return id;
  }
  public void setId(final int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(final String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(final int age) {
    this.age = age;
  }
  public String getInstructorName() {
    return instructorName;
  }
  public void setInstructorName(final String instructorName) {
    this.instructorName = instructorName;
  }
  public String getBatchName() {
    return batchName;
  }
  public void setBatchName(final String batchName) {
    this.batchName = batchName;
  }
  public int getYearOfEnrollment() {
    return yearOfEnrollment;
  }
  public void setYearOfEnrollment(final int yearOfEnrollment) {
    this.yearOfEnrollment = yearOfEnrollment;
  }
  public double getAvgBatchPsp() {
    return avgBatchPsp;
  }
  public void setAvgBatchPsp(final double avgBatchPsp) {
    this.avgBatchPsp = avgBatchPsp;
  }

  public Student(){

  }

  public Student(Student s){
    this.instructorName = s.instructorName;
    this.batchName = s.batchName;
    this.yearOfEnrollment = s.yearOfEnrollment;
    this.avgBatchPsp = s.avgBatchPsp;
  }

  @Override
  public Student clone() {
    return new Student(this);
  }

  @Override public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", instructorName='" + instructorName + '\'' +
        ", batchName='" + batchName + '\'' +
        ", yearOfEnrollment=" + yearOfEnrollment +
        ", avgBatchPsp=" + avgBatchPsp +
        '}';
  }
}

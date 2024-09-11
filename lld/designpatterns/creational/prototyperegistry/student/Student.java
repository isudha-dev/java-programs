package lld.designpatterns.creational.prototyperegistry.student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student implements Prototype<Student>{
  private int id;
  private String name;
  private int age;
  private String instructorName;
  private String batchName;
  private int yearOfEnrollment;
  private double avgBatchPsp;

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

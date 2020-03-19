package org.springapp.entity;

public class Student {

    private int id;

    private String rollNo;

    private String name;

    private String university;

    public Student() {
    }

    public Student(int id, String rollNo, String name, String university) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}

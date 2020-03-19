package org.springapp.dao;

import org.springapp.entity.Student;

import java.util.List;

public interface StudentDao {

    Student save(Student e);

    Student get(int id);

    void remove(int id);

    Student update(Student student);

    List<Student> getStudents();
}

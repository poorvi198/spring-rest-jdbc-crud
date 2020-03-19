package org.springapp.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setRollNo(resultSet.getString("rollno"));
        student.setName(resultSet.getString("name"));
        student.setUniversity(resultSet.getString("university"));
        return student;
    }
}

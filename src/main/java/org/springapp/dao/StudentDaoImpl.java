package org.springapp.dao;

import org.springapp.entity.Student;
import org.springapp.entity.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Student save(Student student) {
       jdbcTemplate.update("insert into student(rollno,name,university) values(?,?,?)",student.getRollNo(),student.getName(),student.getUniversity());
    return student;
    }

    @Override
    public Student get(int id) {
        return jdbcTemplate.queryForObject("select * from student where id = ?",new Object[]{id},new StudentMapper());
    }

    @Override
    public void remove(int id) {
        jdbcTemplate.update("delete from student where id = ?",new Object[]{id});
    }

    @Override
    public Student update(Student student) {
        jdbcTemplate.update("update student set rollno=? , name=?, university=? where id=?",
                student.getRollNo(),student.getName(),student.getUniversity(),student.getId());
        return get(student.getId());
    }

    @Override
    public List<Student> getStudents() {

        return jdbcTemplate.query("select * from student", new StudentMapper());
    }
}

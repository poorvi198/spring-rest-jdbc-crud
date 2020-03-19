package org.springapp.controller;

import org.springapp.dao.StudentDao;
import org.springapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @RequestMapping("/test")
    public String testHello(){
        return "Hello World";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentDao.getStudents();
    }

    @PostMapping(value = "/students")
    public Student saveStudent(@RequestBody Student student){
        Student theStudent = studentDao.save(student);
        return theStudent;
    }

    @GetMapping(value = "/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        return studentDao.get(studentId);
    }

    @DeleteMapping(value = "students/{studentId}")
    public String deleteStudent(@PathVariable int studentId)
    {
        if(getStudent(studentId)==null)
            return "student does not exist";
        studentDao.remove(studentId);
        return "student deleted with id "+studentId;
    }

    @PutMapping(value = "students")
    public Student updateStudent(@RequestBody Student theStudent)
    {
        Student student = studentDao.update(theStudent);
        return student;
    }
}

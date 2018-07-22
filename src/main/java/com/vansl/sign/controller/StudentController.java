package com.vansl.sign.controller;

import com.vansl.sign.entity.Course;
import com.vansl.sign.entity.Student;
import com.vansl.sign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/students",params = {"name"})
    public void add(String name) {
        Student student = new Student();
        student.setName(name);
        studentService.save(student);

    }

    @GetMapping(value = "/student",params = "name")
    public Student queryStudentByName(String name){
        return studentService.findStudentByName(name);
    }

    @GetMapping(value = "/student/{id}")
    public Student queryStudentById(@PathVariable Long id){
        System.out.printf("id");
        return studentService.findStudentById(id);
    }

    @GetMapping(value = "/students")
    public List<Student> queryAll(){
        return studentService.findAll();
    }


    /*
     * 查询某个学生的所有课程
     * */
    @GetMapping(value = "/courses/sid/{studentId}")
    public Set<Course> queryStudentsByCourse(@PathVariable Long studentId){
        return studentService.findCoursesByStudent(studentId);
    }

}

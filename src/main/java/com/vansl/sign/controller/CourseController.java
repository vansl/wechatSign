package com.vansl.sign.controller;

import com.vansl.sign.entity.Course;
import com.vansl.sign.entity.Student;
import com.vansl.sign.service.CourseService;
import com.vansl.sign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Set;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;
    /*
    * 增加课程
    * */
    @PostMapping(value = "/courses",params = {"name","teacherId"})
    public void add(String name,Long teacherId) {
        Course course = new Course();
        course.setName(name);
        course.setTeacherId(teacherId);
        courseService.save(course);

    }

    /*
    * 根据教师Id查询教师的所有课程
    * */
    @GetMapping(value = "/courses/teacher/{teacherId}")
    public Set<Course> queryCoursesByTeacher(@PathVariable Long teacherId){
        return courseService.findCoursesByTeacher(teacherId);
    }

    @GetMapping(value = "/course/{id}")
    public Course queryCourseById(@PathVariable Long id){
        return courseService.findCourseById(id);
    }

    @GetMapping(value = "/courses")
    public List<Course> queryAll(){
        return courseService.findAll();
    }


    /*
     * 查询某门课程的所有学生
     * */
    @GetMapping(value = "/students/cid/{courseId}")
    public Set<Student> queryStudentsByCourse(@PathVariable Long courseId){
        return courseService.findStudentsByCourse(courseId);
    }


    /*
     * 增加课程的学生
     * */
    @PostMapping(value = "/course/{cid}",params = {"studentId"})
    public void addCourseStudent(@PathVariable Long cid,Long studentId) {
        Course course = courseService.findCourseById(cid);
        Student student = studentService.findStudentById(studentId);
        Set<Student> students = course.getStudents();
        students.add(student);
        course.setStudents(students);
        courseService.save(course);
    }
}

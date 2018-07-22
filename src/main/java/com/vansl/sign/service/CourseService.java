package com.vansl.sign.service;

import com.vansl.sign.dao.CourseRepository;
import com.vansl.sign.entity.Course;
import com.vansl.sign.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course findCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    public void save(Course Course){
        courseRepository.save(Course);
    }

    public Set<Course> findCoursesByTeacher(Long teacherId){
        return courseRepository.findCoursesByTeacher(teacherId);
    }

    public Set<Student> findStudentsByCourse(Long courseId){
        Course course = findCourseById(courseId);
        Set<Student> students = course.getStudents();
        return students;
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

}

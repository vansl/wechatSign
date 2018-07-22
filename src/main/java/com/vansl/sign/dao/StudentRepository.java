package com.vansl.sign.dao;

import com.vansl.sign.entity.Course;
import com.vansl.sign.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    /**
     * 根据姓名查询学生
     */
    @Query("from Student s where s.name=:name")
    Student findStudentByName(@Param("name") String name);


    /*
     * 查询某个学生的所有课程
     */
    @Query("select new Course(id) from Course c,Student s,CourseStudent cs " +
            "where s.id=cs.student.id and s.id=:studentId and c.id=cs.course.id ")
    Set<Course> findCoursesByStudent(@Param("studentId") Long studentId);

}



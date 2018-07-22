package com.vansl.sign.dao;

import com.vansl.sign.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    /**
     * 复杂查询使用@Query编写sql
     * 根据姓名查询教师
     * @param name
     * @return
     */
    @Query("from Course u where u.name=:name")
    Course findCourseByName(@Param("name") String name);

    @Query("from Course u where u.teacherId=:teacherId")
    Set<Course> findCoursesByTeacher(@Param("teacherId") Long teacherId);

}
package com.vansl.sign.dao;

import com.vansl.sign.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    /**
     * 复杂查询使用@Query编写sql
     * 根据姓名查询教师
     * @param name
     * @return
     */
    @Query("from Student u where u.name=:name")
    Student findStudentByName(@Param("name") String name);

}



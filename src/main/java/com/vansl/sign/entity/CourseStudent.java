package com.vansl.sign.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/* 课程的学生中间表 */
@Table(name = "t_course_student")
@Entity
@IdClass(CourseStudentKey.class)
@EntityListeners(AuditingEntityListener.class)
public class CourseStudent {

    /* 创建时间 */
    @Column(name = "created_at")
    @CreatedDate
    private Long createdTime;

    /* 更新时间 */
    @Column(name = "updated_at")
    @LastModifiedDate
    private Long updatedTime;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }
}

class CourseStudentKey implements Serializable{
    private Course course;

    private Student student;
}
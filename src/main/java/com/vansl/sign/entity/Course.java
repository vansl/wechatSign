package com.vansl.sign.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "t_course")
@Entity
public class Course extends BaseEntity{

    /* 课程名称 */
    @Column
    private String name;

    /* 教师id */
    @Column(name = "teacher_id")
    private Long teacherId;

    /* 参加课程的学生 */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_course_student", joinColumns = {
            @JoinColumn(name = "course_id")}, inverseJoinColumns = {
            @JoinColumn(name = "student_id")})
    private Set<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}

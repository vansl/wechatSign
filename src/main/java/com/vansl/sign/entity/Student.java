package com.vansl.sign.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "t_student")
@Entity
public class Student extends BaseEntity{

    /* 学生姓名 */
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

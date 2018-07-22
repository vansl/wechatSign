package com.vansl.sign.controller;

import com.vansl.sign.entity.Teacher;
import com.vansl.sign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/getString")
    public String getString() {
        return "Hello 张三";
    }

    @PostMapping(value = "/teachers",params = {"name"})
    public void add(String name) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacherService.save(teacher);

    }

    @GetMapping(value = "/teacher",params = "name")
    public Teacher queryTeacherByName(String name){
        return teacherService.findTeacherByName(name);
    }

    @GetMapping(value = "/teacher/{id}")
    public Teacher queryTeacherById(@PathVariable Long id){
        System.out.printf("id");
        return teacherService.findTeacherById(id);
    }

    @GetMapping(value = "/teachers")
    public List<Teacher> queryAll(){
        return teacherService.findAll();
    }

}

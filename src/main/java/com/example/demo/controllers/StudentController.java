package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/hello")
    public String hello(ModelMap modelMap){
        return "hello world. OKOKOK";
    }
    @PostMapping("/insert")
    public String insertStudent(@RequestParam String name, @RequestParam Integer birthYear){
        try{
            Student student = new Student(name, birthYear);
            studentRepository.save(student);
            return "Insert ok";
        }catch (Exception e){
            return "insert faild" +e.toString();
        }
    }
    @GetMapping("showALll")
    public Iterable<Student> showAll(){
        return studentRepository.findAll();
    }
}

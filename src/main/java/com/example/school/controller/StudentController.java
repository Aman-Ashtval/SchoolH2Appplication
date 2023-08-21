package com.example.school.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;
import org.springframework.beans.factory.annotation.Autowired;

@RestController 
public class StudentController{
    @Autowired
    public StudentH2Service studentService;

    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.deleteStudent(studentId);    
    }

    @PostMapping("/students/bulk")
    public String addMultipleStudents(@RequestBody ArrayList<Student> studentList){
        return studentService.addMultipleStudents(studentList);
    }
}

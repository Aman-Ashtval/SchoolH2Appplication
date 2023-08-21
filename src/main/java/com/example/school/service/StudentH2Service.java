package com.example.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import com.example.school.model.*;
import com.example.school.repository.StudentRepository;

@Service 
public class StudentH2Service implements StudentRepository{
    @Autowired 
    private JdbcTemplate db;

    @Override 
    public ArrayList<Student> getStudents(){
        List<Student> studentList = db.query("SELECT * FROM STUDENT", new StudentRowMapper());
        return new ArrayList<>(studentList);
    }

    @Override 
    public Student addStudent(Student student){
        db.update("INSERT INTO STUDENT (studentName, gender, standard) VALUES (?, ?, ?)", student.getStudentName(), student.getGender(), student.getStandard());
        Student newStudent = db.queryForObject("SELECT * FROM STUDENT WHERE studentName = ? AND standard = ?", new StudentRowMapper(), student.getStudentName(), student.getStandard());
        return newStudent;
    }

    @Override 
    public Student getStudentById(Integer studentId){
        try{
            Student existStudent = db.queryForObject("SELECT * FROM STUDENT WHERE studentId = ?", new StudentRowMapper(), studentId);
            return existStudent;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Student updateStudent(Integer studentId, Student student){
        if(getStudentById(studentId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(student.getStudentName() != null){
            db.update("UPDATE STUDENT SET studentName = ? WHERE studentId = ?", student.getStudentName(), studentId);
        }
        if(student.getGender() != null){
            db.update("UPDATE STUDENT SET gender = ? WHERE studentId = ?", student.getGender(), studentId);
        }
        if(student.getStandard() != 0){
            db.update("UPDATE STUDENT SET standard = ? WHERE studentId = ?", student.getStandard(), studentId);
        }

        return getStudentById(studentId);
    }

    @Override 
    public void deleteStudent(Integer studentId){
        db.update("DELETE FROM STUDENT WHERE studentId = ?", studentId);    
    }

    @Override 
    public String addMultipleStudents(ArrayList<Student> studentList){
        for(Student eachStudent:studentList){
            addStudent(eachStudent);
        }
        return "Successfully added " + studentList.size() + " students";
    }
}